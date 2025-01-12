package ecomistika.central.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.UniqueConstraint;
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
@Table(name = "product",
       
        indexes = {
             @Index(columnList = "codeBar"),  // Added index on name
            @Index(columnList = "name"),  // Added index on name
            @Index(columnList = "product_number")})  // Added index on product_number
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;
    private String product_number;
    private String name;
    private String description;
    private Double cost;
    private Double price;
    private Double profit_margin;
    private Boolean isEnabled;
    private String codeBar;

    private LocalDateTime creation_date;
    private LocalDateTime last_updated_date;
  
    @ManyToOne
    private Category category;

    @ManyToOne
    private Company company;
   
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Stock stock;

    @ManyToOne
    private Owner owner; 

}
