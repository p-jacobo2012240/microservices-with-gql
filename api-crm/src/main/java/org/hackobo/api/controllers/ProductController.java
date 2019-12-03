package org.hackobo.api.controllers;

import java.util.List;

import org.hackobo.api.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.hackobo.api.entity.Product;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	@Autowired
	private ProductRepository productDao;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> findAllProducts(){
		List<Product> products  = (List<Product>) productDao.findAll();
		if( products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>( products, HttpStatus.OK);
	}
	
	@GetMapping("/product/{id}")
	public Product findByIdProduct(@PathVariable Long id)  {
		return this.productDao.findById(id).orElse(null);
	}
	

}
