package org.hackobo.api.dao;

import org.hackobo.api.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
	//empty
}
