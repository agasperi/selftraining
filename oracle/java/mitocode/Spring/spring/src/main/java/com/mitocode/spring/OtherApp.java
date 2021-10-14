package com.mitocode.spring;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.beans.Barcelona;
import com.mitocode.beans.Jugador;
import com.mitocode.beans.Juventus;
import com.mitocode.interfaces.IEquipo;

public class OtherApp {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Jugador player = (Jugador) appContext.getBean("jugador1");
		
		/*
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/mitocode/xml/otherbeans.xml");
		Jugador player = (Jugador) appContext.getBean("jugador1");
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Eliga un equipo: \n\t1-Barcelona FC\n\t2-Juventus");
		System.out.print("Eleccion:");
		int equipo = sc.nextInt();
		
		switch(equipo) {
			case 1:
				player.setEquipo(new Barcelona());
				break;
			case 2:
				player.setEquipo(new Juventus());
			default:
				break;
		}
		
		
		System.out.println(player.getNombre() + " - " + player.getEquipo().mostrar() + " - " 
				+ player.getCamiseta().getNumero() + " - " + player.getCamiseta().getMarca().getNombre());
		
		
		/*Jugador player = (Jugador) appContext.getBean("jugador");*/
		/*Jugador player = (Jugador) appContext.getBean("messi");
		System.out.println(player.getNombre() + " - " + player.getEquipo().mostrar());*/		
		
		/*
		IEquipo equipo = (IEquipo) appContext.getBean("barcelona");
		System.out.println(equipo.mostrar());
		*/
		
		((ConfigurableApplicationContext) appContext).close();
		
	}

}
