package com.training.spring.consumesoap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class BankConfiguration {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshall = new Jaxb2Marshaller();
		marshall.setContextPath("com.training.spring.wsdl");
		return marshall;
	}
	
	@Bean
	public BankClient bankClient(Jaxb2Marshaller marshaller) {
		BankClient client = new BankClient();
		client.setDefaultUri("http://www.thomas-bayer.com/axis2/services/BLZService?wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
