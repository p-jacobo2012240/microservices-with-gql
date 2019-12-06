package org.hackobo.getway.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
import org.hackobo.getway.entity.Product;
import org.hackobo.getway.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private RestTemplate restClient;
	
	@Override
	public List<Product> listAllProduct() {
		List<Object> products = Arrays.asList( 
			restClient.getForObject("http://localhost:8001/api/v1/products", Product[].class));
		//use streams
		return products.stream()
				.map(p -> new Product( )) //verify constructors app
				.collect(Collectors.toList()) ;
	}

}
