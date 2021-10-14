package com.mitocode.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.beans.Marca;
import com.mitocode.dao.DAOMarca;
import com.mitocode.service.ServiceMarca;

@Service
public class ServiceMarcaImpl implements ServiceMarca {
	@Autowired
	private DAOMarca daoMarca;
	
	@Override
	public void registrar(Marca marca) throws Exception {
		try {
			daoMarca.registrar(marca);
		} catch (Exception e) {
			throw e;
		}
	}

}
