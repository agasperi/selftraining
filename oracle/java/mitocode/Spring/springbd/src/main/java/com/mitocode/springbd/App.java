package com.mitocode.springbd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.beans.Jugador;
import com.mitocode.beans.Marca;
import com.mitocode.service.ServiceJugador;
import com.mitocode.service.ServiceMarca;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
    	Marca marca = new Marca();
        marca.setId(2);
        marca.setNombre("Marca2");
        */
        ApplicationContext appContext = new ClassPathXmlApplicationContext("com/mitocode/xml/beans.xml");
        ServiceJugador sj = (ServiceJugador) appContext.getBean("serviceJugadorImpl");
        Jugador jugador = (Jugador) appContext.getBean("messi");
        
        try {
			sj.registrar(jugador);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        /*
        ServiceMarca sm = (ServiceMarca) appContext.getBean("serviceMarcaImpl");
        
        try {
			sm.registrar(marca);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		*/
        
        ((ConfigurableApplicationContext) appContext).close();
    }
}
