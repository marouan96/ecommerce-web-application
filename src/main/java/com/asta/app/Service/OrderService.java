package com.asta.app.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asta.app.Repository.OrderRepository;
import com.asta.app.model.Order;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	

    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }
    
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());

        return this.orderRepository.save(order);
    }

    public void update(Order order) {
        this.orderRepository.save(order);
    }	
	
	

}
