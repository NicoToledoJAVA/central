package ecomistika.central.model;

import ecomistika.central.model.auth.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserPOS implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String userName;
    private String passwordHash;
    private String firstName;
    private String lastName;
    private String id_number;
    private Boolean enabled;
    private Boolean accountNotExpired;
    private Boolean accountNotLocked;
    private Boolean credentialNotExpired;
    
   

    @OneToMany(mappedBy = "seller")  // Este debe coincidir con el nombre del atributo en la entidad Sale
    private List<Sale> userSalesList;
    
    @ManyToOne
    private Owner owner;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));

    }
    
     @Override
    public String getUsername() {
          return userName;
    }

  
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        // Excluir referencias mutuas
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserPOS other = (UserPOS) obj;
        if (userName == null) {
            if (other.userName != null) {
                return false;
            }
        } else if (!userName.equals(other.userName)) {
            return false;
        }
        if (firstName == null) {
            if (other.firstName != null) {
                return false;
            }
        } else if (!firstName.equals(other.firstName)) {
            return false;
        }
        return true;

    }

    @Override
    public String toString() {
        return "UserSec{"
                + "id=" + id
                + ", user_name='" + userName + '\''
                + ", name='" + firstName + '\''
                + ", familyName='" + lastName + '\''
                + ", identification_num='" + id_number + '\''
                + ", enabled=" + enabled
                + ", accountNotExpired=" + accountNotExpired
                + ", accountNotLocked=" + accountNotLocked
                + ", credentialNotExpired=" + credentialNotExpired
                + '}';
    }

   
}
