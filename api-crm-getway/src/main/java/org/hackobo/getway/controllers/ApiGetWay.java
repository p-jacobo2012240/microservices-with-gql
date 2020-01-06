package org.hackobo.getway.controllers;

import java.util.List;

import org.hackobo.getway.entity.Order;
import org.hackobo.getway.entity.Product;
import org.hackobo.getway.implementations.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getway")
public class ApiGetWay {

	@Autowired
	private OrderServiceImpl orderService;
	
	/*@GetMapping("/products")
	public List<Order> allProductsAPI(){
		return this.orderService.listAllOrder();
	}*/
	
}
