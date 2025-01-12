/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "stock")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false) // Clave foránea aquí
    private Product product;

    @Column(name = "stock", nullable = false) // Asegúrate de que esto sea un @Column y no un @JoinColumn
    private Integer currentStock; // Cantidad disponible del producto

    private Double restockPoint;
    
    private Boolean lowStockWarningStatus;
    
    private Double lowStockWarningQuantity;
    
    private Double desiredStockLevel;
    
    @ManyToOne
    private Company company;

}
