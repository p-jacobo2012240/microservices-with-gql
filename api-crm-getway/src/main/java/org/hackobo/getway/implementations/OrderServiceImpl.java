package org.hackobo.getway.implementations;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.hackobo.getway.entity.Order;
import org.hackobo.getway.entity.Product;
import org.hackobo.getway.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {
	
	private static final String API_CRM_v2 = "http://localhost:8001/api/v1";
	
	@Autowired
	private RestTemplate restClient;
	
	
	@Override
	public List<Order> listAllOrder() {
		List<Object> productList = 
				Arrays.asList(restClient
				.getForObject(API_CRM_v2
				.concat("/products"),  Product[].class));
		System.out.println("itssss :::::::::::::::::::::::::" + productList );	
		
		return null;
	}

}
