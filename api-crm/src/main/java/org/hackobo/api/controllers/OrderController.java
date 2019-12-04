package org.hackobo.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hackobo.api.dao.OrderRepository;
import org.hackobo.api.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
	public ResponseEntity<?> findByIdOrder(@PathVariable Long id ) {
		Order order = null;
		if( id == null ||  id < 0 ) {
			this.res.put("message", "invalid parameter!");
			return new ResponseEntity<Map<String, Object>>(this.res, HttpStatus.CONFLICT);
		}
		
		try {
			order = orderDao.findById(id).orElse(null);
		}catch(DataAccessException e) {
			this.res.put("message", "has error" + e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
	
	
	
}
