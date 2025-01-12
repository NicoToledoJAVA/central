package ecomistika.central.model;

import jakarta.persistence.*;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "customer")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String streetName;
    private String postalCode;
    private String city;
    private LocalDateTime creation_date;
    private LocalDateTime last_updated_date;
    private String email;
    private String phoneNumber;
    private Boolean isEnabled;
    private String idNumber;
    private String taxNumber;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Sale> sales;


    @ManyToOne
    private Owner owner;      // dueño

}
