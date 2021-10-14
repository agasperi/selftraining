package com.mitocode.beans;

import org.springframework.stereotype.Component;

import com.mitocode.interfaces.IEquipo;

@Component
public class Juventus implements IEquipo {

	@Override
	public String mostrar() {
		return "Juventus";
	}

}
