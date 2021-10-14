package com.mitocode.beans;

import org.springframework.stereotype.Component;

import com.mitocode.interfaces.IEquipo;

@Component
public class Barcelona implements IEquipo {

	@Override
	public String mostrar() {
		// TODO Auto-generated method stub
		return "Barcelona FC";
	}

}
