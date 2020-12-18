package com.thymeleaf.thymeleaf_dz.dto;

import com.thymeleaf.thymeleaf_dz.model.ProductType;
import lombok.*;

import java.math.BigDecimal;

@ToString
@EqualsAndHashCode
@Builder
@Data
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private BigDecimal cost;
    private ProductType type;
    private String description;
}
