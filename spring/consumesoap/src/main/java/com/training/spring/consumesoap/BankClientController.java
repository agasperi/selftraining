package com.training.spring.consumesoap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.wsdl.GetBankResponseType;


@RestController
public class BankClientController {

	@Autowired
	BankClient bankClient;
	
	@RequestMapping(value="/bzl",
	        method=RequestMethod.GET,
	        produces="application/json")
	@ResponseBody
	public GetBankResponseType getBZLCode() {
		GetBankResponseType response = bankClient.getBankResponse("28021301");
		return response;
	}
}
