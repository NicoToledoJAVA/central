
package ecomistika.central.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String name;  
    private String address;   
    private String postalCode;
    private String streetName;
    private String BuildingNumber;
    private String cityName;
    private String taxId;  
    private String email;   
    private String phoneNumber;   
    private String logoUrl;
    
    
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Product> products;
    
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Tax> taxes;
    
     @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Stock> stocks;
    
    @ManyToOne
    private Owner owner;  
}
