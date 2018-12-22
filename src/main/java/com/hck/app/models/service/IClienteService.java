package com.hck.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hck.app.models.entity.Cliente;

public interface IClienteService {
	
		//Listar los registros
		public List<Cliente> findAll();
		
		//Paginando los resultados
		public Page<Cliente> findAll(Pageable pagable  );
		
		
		//Guardar un registo
		public void save(Cliente cliente);
		
		//Editar un registro
		public Cliente finOne(Long id);
		
		//Eliminar un registro
		public void eliminar(Long id);
}
