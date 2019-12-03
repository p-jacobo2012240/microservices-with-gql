package org.hackobo.api.controllers;

import java.util.List;

import org.hackobo.api.dao.OrderRepository;
import org.hackobo.api.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderDao;
	
	@GetMapping("/orders")
	public List<Order> findAllOrders(){
		return (List<Order>) this.orderDao.findAll();
	}
	
	@GetMapping("/order/{id}")
	public Order findByIdOrder(@PathVariable Long id ) {
		return this.orderDao.findById(id).orElse(null);
	}
	
	
	
	
}
