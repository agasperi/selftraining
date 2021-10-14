package com.mitocode.beans;

public class Ciudad {
	
	private String nombre;
	
	/*
	private void initBean() {
		System.out.println("Antes de inicializar el bean Ciudad");
	}
	
	private void destroyBean() {
		System.out.println("El bean Ciudad a punto de ser destruido");
	}
	*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
