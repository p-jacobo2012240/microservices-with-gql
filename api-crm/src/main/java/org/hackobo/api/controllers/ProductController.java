package org.hackobo.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hackobo.api.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.hackobo.api.entity.Product;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductRepository productDao;
	private Map<String, Object> res = new HashMap();
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> findAllProducts() {
		List<Product> products = (List<Product>) productDao.findAll();
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<?> findByIdProduct(@PathVariable Long id) {
		Product product = null;
		
		try {
			product = productDao.findById(id).orElse(null);
		} catch (DataAccessException e) {
			this.res.put("message", "has error" + e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (product == null) {
			res.put("message", "the product with id: " + id.toString() + "en la db");
			return new ResponseEntity<Map<String, Object>>(res, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PostMapping("/product")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		Product newProduct = null;
		
		try {
			newProduct = productDao.save(product);
		}catch(DataAccessException e) {
			this.res.put("body", product);
			this.res.put("message", "has error" + e.getMostSpecificCause());
			return new ResponseEntity<Product>(product, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED );
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Map<String, Object>> removeByIdProduct(@PathVariable Long id){
		try {
			productDao.deleteById(id);
		}catch(DataAccessException e) {
			this.res.put("message", "has error" + e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object >>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		this.res.put("message", "product deleted");
		return new ResponseEntity<Map<String, Object>>(this.res, HttpStatus.OK );
	}

}
