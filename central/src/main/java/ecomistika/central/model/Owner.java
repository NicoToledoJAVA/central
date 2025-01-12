package ecomistika.central.model;

import ecomistika.central.model.auth.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import lombok.*;

import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "owner",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"nickName"}),
            @UniqueConstraint(columnNames = {"mail"}) // Nueva restricción única
        },
        indexes = {
            @Index(columnList = "nickName"),
            @Index(columnList = "mail"), // Nuevo índice
        })
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owner implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nickName;
    private String passwordHash;
    private String name;
    private String familyName;
    @Column(unique = true)
    private String mail;
    private Boolean enabled;
    private Boolean accountNotExpired;
    private Boolean accountNotLocked;
    private Boolean credentialNotExpired;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Category> categories;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Company> companies;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Customer> customers;  // Métodos de pago

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<PaymentMethod> paymentMethods;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Sale> sales;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Product> sale_items;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<UserPOS> users;

      
  // Implementación de UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority("ROLE_USER"),
                new SimpleGrantedAuthority("ROLE_ADMIN")
        );
    }

    

    @Override
    public String getUsername() {
        return this.nickName; // Ajustado para devolver el nombre de usuario
    }

    @Override
    public String getPassword() {
        return this.passwordHash;
    }

    @Override
    public boolean isAccountNonLocked() {
        return Boolean.TRUE.equals(accountNotLocked);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return Boolean.TRUE.equals(credentialNotExpired);
    }

    @Override
    public boolean isAccountNonExpired() {
        return Boolean.TRUE.equals(accountNotExpired);
    }

    @Override
    public boolean isEnabled() {
        return Boolean.TRUE.equals(enabled);
    }
   
  

    

}
