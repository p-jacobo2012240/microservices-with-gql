package org.hackobo.api.controllers;

import java.util.List;

import org.hackobo.api.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.hackobo.api.entity.Product;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productDao;
	
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return (List<Product>) productDao.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Product findByIdProduct(@PathVariable Long id)  {
		return this.productDao.findById(id).orElse(null);
	}
	

}
