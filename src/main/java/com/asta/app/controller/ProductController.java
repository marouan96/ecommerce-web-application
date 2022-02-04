package com.asta.app.controller;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	     
	    @GetMapping("/products")
	    public Page<Product> getPageableProducts(@RequestParam(value = "page",defaultValue = "1") Integer page,@RequestParam(value = "size",defaultValue = "3") Integer size){
	    	PageRequest request= PageRequest.of(page-1,size);
	    	return productService.findAll(request);
	    }

	    @GetMapping("/products/{Id}")
	    public Product getProduct(@PathVariable("Id") long id){
	    	return productService.FindById(id);
	    	
	    }
	    
	    
}

