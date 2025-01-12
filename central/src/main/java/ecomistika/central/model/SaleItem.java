package ecomistika.central.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "sale_item",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"owner_id"}),
            @UniqueConstraint(columnNames = {"sale_id"})
        },
        indexes = {
            @Index(columnList = "owner_id"),
            @Index(columnList = "sale_id")
        })
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;
    private String name;
    private String description;
    private Double discount;
    private Integer quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
