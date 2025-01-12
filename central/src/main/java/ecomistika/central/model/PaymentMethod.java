
package ecomistika.central.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
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
@Table(name = "payment_method")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name; // Nombre del tipo de pago (ej. Efectivo, Tarjeta de crédito)

    @Column(name = "code")
    private String code; // Código opcional para identificar el tipo de pago    
    
    private String shortcutKey;
    
    @Column(name = "ordinal", nullable = false)
    private Integer ordinal; // Posición o prioridad en el sistema de pago

    @Column(name = "is_enabled", nullable = false)
    private Boolean isEnabled; // ¿Está habilitado este tipo de pago?

    @ManyToOne
    private Owner owner;  // Dueño
   

    
}