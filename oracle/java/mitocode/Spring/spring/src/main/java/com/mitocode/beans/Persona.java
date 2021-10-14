package com.mitocode.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/*public class Persona{*/
public class Persona implements InitializingBean, DisposableBean{
	private int id;
	private String nombre;
	private String apodo;
	private Pais pais;
	private Ciudad ciudad;
	
	public Persona() {
		
	}
	
	/*
	private void initBean() {
		System.out.println("Antes de inicializar el bean Persona");
	}
	
	private void destroyBean() {
		System.out.println("El bean Persona a punto de ser destruido");
	}
	*/
	
	public Persona(int id, String nombre, String apodo) {
		this.setId(id);
		this.setNombre(nombre);
		this.setApodo(apodo);
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("DESPUÉS de inicializar el bean Persona");
	}
	
	
	@Override
	public void destroy() throws Exception {
		System.out.println("DESTROY el bean Persona");
	}
	
	
}
