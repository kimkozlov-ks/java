package com.thymeleaf.thymeleaf_dz.mapper;

import com.thymeleaf.thymeleaf_dz.dto.ProductDto;
import com.thymeleaf.thymeleaf_dz.model.Product;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {


    public ProductDto productToProductDto(@NonNull Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .cost(product.getCost())
                .description(product.getDescription())
                .type(product.getType())
                .build();
    }

    public Product productDtoToProduct(@NonNull ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .cost(productDto.getCost())
                .description(productDto.getDescription())
                .type(productDto.getType())
                .build();
    }
}
