package com.asta.app.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asta.app.model.OrderProduct;
import com.asta.app.repository.OrderProductRepository;

@Service
public class OrderProductService {

	@Autowired
	private OrderProductRepository orderProductRepository;
	
	public OrderProduct create(@Valid OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}
