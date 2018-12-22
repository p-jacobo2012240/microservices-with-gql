package com.hck.app.models.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hck.app.models.dao.IClienteDao;
import com.hck.app.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService  {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();	
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		 clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente finOne(Long id) {
		return clienteDao.findOne(id);
		//return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		//((ClienteServiceImpl) clienteDao).eliminar(id);
		 clienteDao.findOne(id);
	}

	@Override
	public Page<Cliente> findAll(Pageable pagable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pagable) ;
	}

}
