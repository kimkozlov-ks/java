package com.thymeleaf.thymeleaf_dz.controller;

import com.thymeleaf.thymeleaf_dz.dto.ProductDto;
import com.thymeleaf.thymeleaf_dz.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("pageTitle", "СПИСОК ТОВАРОВ");
        model.addAttribute("currentDate", LocalDate.now().toString());

        return "index";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        ProductDto productDto = ProductDto.builder()
                .build();

        model.addAttribute("product", productDto);
        model.addAttribute("pageTitle", "Дабавление товара");
        model.addAttribute("currentDate", LocalDate.now().toString());

        return "add";
    }

    @PostMapping("/add")
    public String addProduct(Model model, @ModelAttribute ProductDto productDto) {
        ProductDto createdProduct = productService.addProduct(productDto);

        if (createdProduct == null) {
            return "/add";
        }

        return "redirect:/product";
    }
}
