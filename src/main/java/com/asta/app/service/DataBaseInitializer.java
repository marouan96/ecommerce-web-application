package com.asta.app.service;

import com.asta.app.model.Product;
import com.asta.app.model.User;
import com.asta.app.repository.ProductRepository;
import com.asta.app.repository.UserRepository;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DataBaseInitializer {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init() throws IOException, URISyntaxException {
		userRepository.save(new User("marouan","marouan@gamil.com","6523147856","street 24",passwordEncoder.encode("pass"),"CUSTOMER"));
	    for(int i=0;i<20;i++){
             Product p=new Product("Dernier jour",25,"ldc 30 pages by victor hugo",95.5,"Books");
			 setBookImage(p, "/images/350x150.png");
			 productRepository.save(p);
		}
	}
	
	public void setBookImage(Product product, String classpathResource) throws IOException{
      product.setImage(true);
	  Resource image= new ClassPathResource(classpathResource);
	  product.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
	}
}
