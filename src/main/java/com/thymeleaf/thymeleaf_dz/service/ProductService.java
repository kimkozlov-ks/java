package com.thymeleaf.thymeleaf_dz.service;

import com.thymeleaf.thymeleaf_dz.dto.ProductDto;
import com.thymeleaf.thymeleaf_dz.mapper.ProductMapper;
import com.thymeleaf.thymeleaf_dz.model.Product;
import com.thymeleaf.thymeleaf_dz.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductDto addProduct(ProductDto productDto) {
        Product product = productMapper.productDtoToProduct(productDto);

        Product createdProduct = productRepository.save(product);

        return productMapper.productToProductDto(createdProduct);
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> productMapper.productToProductDto(product))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
