package com.mitocode.spring;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.beans.AppConfig;
import com.mitocode.beans.AppConfig2;
import com.mitocode.beans.Ciudad;
import com.mitocode.beans.Mundo;
import com.mitocode.beans.Persona;

public class App {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/mitocode/xml/beans.xml");
		Persona persona = (Persona) appContext.getBean("personabean");
		Persona per2 = (Persona) appContext.getBean("personabean");
		Ciudad ciudad = (Ciudad) appContext.getBean("ciudad");
		
		persona.setId(1);
		persona.setNombre("Jaime");
		persona.setApodo("MitoCode");
		
		System.out.println(persona.getApodo());
		System.out.println(ciudad.getNombre());
		
		System.out.println(persona.getId() + " " + persona.getNombre() + " "
				+ persona.getApodo() + " " + persona.getPais().getNombre() + " "
				+ persona.getCiudad().getNombre());
		System.out.println(per2.getId() + " " + per2.getNombre() + " "
				+ per2.getApodo() + " " + per2.getPais().getNombre() + " "
				+ per2.getCiudad().getNombre());
		
		System.out.println(persona);
		System.out.println(per2);
		
		/* ApplicationContext appContext = new ClassPathXmlApplicationContext("com/mitocode/xml/beans.xml");
			Persona persona = (Persona) appContext.getBean("personabean2");
			
			String ciudades = persona.getPais().getCiudades().stream()
				.map(ciudad -> ciudad.getNombre())
				.collect(Collectors.joining("-"));
			System.out.println(persona.getId() + " " + persona.getNombre() + " "
					+ persona.getApodo() + " " + persona.getPais().getNombre() + " "
					+ persona.getPais().getCapital().getNombre() + " "
					+ ciudades);*/
		
		/*StringBuilder nombreCiudades = new StringBuilder();
		persona.getPais().getCiudades().
			forEach(ciudad -> nombreCiudades.append(" " + ciudad.getNombre()));
		System.out.println(persona.getId() + " " + persona.getNombre() + " "
				+ persona.getApodo() + " " + persona.getPais().getNombre() + " "
				+ persona.getPais().getCapital().getNombre() + nombreCiudades.toString());*/
		
		/*ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class, AppConfig2.class);*/
		
		/*AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.register(AppConfig.class);
		appContext.register(AppConfig2.class);
		appContext.refresh();*/
		
		/*Mundo mundo = (Mundo) appContext.getBean("marte");
		System.out.println(mundo.getSaludo());*/
		
		((ConfigurableApplicationContext) appContext).close();
	}

}
