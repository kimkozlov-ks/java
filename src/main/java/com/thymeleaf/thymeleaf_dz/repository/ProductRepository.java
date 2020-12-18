package com.thymeleaf.thymeleaf_dz.repository;

import com.thymeleaf.thymeleaf_dz.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    List<Product> findAll();
}
