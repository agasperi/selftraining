package com.training.spring.consumesoap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.training.spring.wsdl.GetBankResponseType;

@SpringBootApplication
public class ConsumesoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumesoapApplication.class, args);
	}
	/*
	@Bean
	CommandLineRunner lookup(BankClient bankClient) {
		return args -> {
			String blzCode = "MSFT";
			if(args.length > 0) {
				blzCode = args[0];
			}
			GetBankResponseType response = bankClient.getBankResponse(blzCode);
			System.err.println(response.getDetails());
		};
	}*/
	
}
