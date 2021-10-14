package com.mitocode.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mitocode.interfaces.IEquipo;

/*@Component("messi")*/
@Component
public class Jugador {
	
	private int id;
	@Value("MitoCode")
	private String nombre;
	@Autowired
	@Qualifier("barcelona")
	private IEquipo equipo;
	@Autowired
	private Camiseta camiseta;
	
	/*
	private int numero;
	@Value("Lionel Messi")
	private String nombre;*/
	
	/*@Autowired*/
	/*@Qualifier("barcelonaQualifier")*/
	/*private IEquipo equipo;*/
	
	/*
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	*/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Camiseta getCamiseta() {
		return camiseta;
	}

	public void setCamiseta(Camiseta camiseta) {
		this.camiseta = camiseta;
	}

	public String getNombre() {
		return nombre;
	}
	
	/*@Required*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public IEquipo getEquipo() {
		return equipo;
	}
	
	/*@Required*/
	public void setEquipo(IEquipo equipo) {
		this.equipo = equipo;
	}
}
