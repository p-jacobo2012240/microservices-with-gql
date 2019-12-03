package org.hackobo.api.dao;

import org.hackobo.api.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
	//non jpql
}
