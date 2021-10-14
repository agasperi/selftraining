package com.mitocode.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mitocode.beans.Barcelona;
import com.mitocode.beans.Camiseta;
import com.mitocode.beans.Jugador;
import com.mitocode.beans.Juventus;
import com.mitocode.beans.Marca;

@Configuration
public class AppConfig {
	
	@Bean
	public Jugador jugador1() {
		return new Jugador();
	}
	
	@Bean
	public Barcelona barcelona() {
		return new Barcelona();
	}
	
	@Bean
	public Juventus juventus() {
		return new Juventus();
	}
	
	@Bean
	public Camiseta camiseta() {
		return new Camiseta();
	}
	
	@Bean
	public Marca marca() {
		return new Marca();
	}


}
