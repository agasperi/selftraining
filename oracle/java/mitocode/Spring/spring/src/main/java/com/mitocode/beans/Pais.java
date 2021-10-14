package com.mitocode.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Pais {
	
	private String nombre;
	/*private Ciudad capital;
	private List<Ciudad> ciudades;*/
	
	@PostConstruct
	private void initBean() {
		System.out.println("Antes de inicializar el bean Pais");
	}
	
	@PreDestroy
	private void destroyBean() {
		System.out.println("El bean Pais a punto de ser destruido");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*public Ciudad getCapital() {
		return capital;
	}

	public void setCapital(Ciudad capital) {
		this.capital = capital;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	*/
}
