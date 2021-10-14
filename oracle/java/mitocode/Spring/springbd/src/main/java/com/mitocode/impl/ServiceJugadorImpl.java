package com.mitocode.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.beans.Jugador;
import com.mitocode.dao.DAOJugador;
import com.mitocode.service.ServiceJugador;

@Service
public class ServiceJugadorImpl implements ServiceJugador {
	@Autowired
	DAOJugador daoJugador;

	@Override
	public void registrar(Jugador jugador) throws Exception {
		try {
			daoJugador.registrar(jugador);
		} catch(Exception e){
			throw e;
		}
	}

}
