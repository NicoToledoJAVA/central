package ecomistika.central.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WineDTO {

    private Long id;
    private String photo;
    private String barCode;
    private String name;
    private String type;
    private String Category;
    private Double price;
    private Integer year;
    private LocalDateTime acquisitionDate;
    private Double alcoholPercentage;
    private String region;
    @OneToOne
    private Nota notas;

}

