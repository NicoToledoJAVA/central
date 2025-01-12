package ecomistika.central.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "sale",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"customer"}),
            @UniqueConstraint(columnNames = {"seller"}),
            
        },
        indexes = {
            @Index(columnList = "customer"),
            @Index(columnList = "seller"),
            @Index(columnList = "owner")
        })
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sale_number;
 
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleItem> saleItems;
  

    private String status;
    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "owner", nullable = false)
    private Owner owner;  // Dueño

    @ManyToOne
    @JoinColumn(name = "seller", nullable = false)
    private UserPOS seller;  // Vendedor
}
