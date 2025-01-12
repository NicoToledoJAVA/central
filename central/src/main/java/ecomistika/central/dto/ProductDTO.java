
package ecomistika.central.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String product_number;
    private String name;
    private Double price;    
    private String codeBar;
    private Integer stock;

}
