package com.asta.app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.asta.app.model.Product;
import com.asta.app.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product FindById(long id){
		return repository.findById(id).get();
	}
	
	public Iterable<Product> findAll(){
		return repository.findAll();
		
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
	
	public Page<Product> findAll(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	public Page<Product> findAllByDepartment(String department,Pageable pageable){
		return repository.findAllByDepartment(department, pageable);
	}
	
}
