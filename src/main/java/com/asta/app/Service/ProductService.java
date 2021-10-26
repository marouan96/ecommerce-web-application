package com.asta.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asta.app.model.Product;
import com.asta.app.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Optional<Product> FindById(long id){
		return repository.findById(id);
	}
	
	public boolean Exist(long id) {
		return repository.existsById(id);
	}
	
	public void Save(Product product) {
		repository.save(product);
	}
	
	public void DeleteById(long id) {
		repository.deleteById(id);
	}
	
}
