package com.asta.app.controller;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asta.app.model.Product;
import com.asta.app.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	    private ProductService productService;

	    public ProductController(ProductService productService) {
	        this.productService = productService;
	    }

	    @GetMapping("/")
	    public @NotNull Iterable<Product> getProducts() {
	        return productService.findAll();
	    }
}

