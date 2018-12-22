package com.hck.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hck.app.models.entity.Cliente;

public interface IClienteDao extends PagingAndSortingRepository <Cliente, Long> {
	
	
}

