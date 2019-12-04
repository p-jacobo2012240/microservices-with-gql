package org.hackobo.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hackobo.api.dao.OrderRepository;
import org.hackobo.api.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderDao;
	private Map<String, Object> res = new HashMap();
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> findAllOrders(){
		List<Order> orders = (List<Order>) this.orderDao.findAll();
		if( orders.isEmpty()) {
			return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	@GetMapping("/order/{id}")
	public Order findByIdOrder(@PathVariable Long id ) {
		return this.orderDao.findById(id).orElse(null);
	}
	
	
	
	
}
