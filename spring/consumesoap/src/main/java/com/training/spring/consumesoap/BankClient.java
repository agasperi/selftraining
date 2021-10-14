package com.training.spring.consumesoap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.training.spring.wsdl.GetBankResponseType;
import com.training.spring.wsdl.GetBankType;

public class BankClient extends WebServiceGatewaySupport{
	public static final Logger log = LoggerFactory.getLogger(BankClient.class);
	
	public GetBankResponseType getBankResponse(String blzCode) {
		GetBankType request = new GetBankType();
		request.setBlz(blzCode);
		log.info("Request. BLZCode: " + request);
		GetBankResponseType response = (GetBankResponseType) getWebServiceTemplate()
				.marshalSendAndReceive("http://www.thomas-bayer.com/axis2/services/BLZService?wsdl",
						request);
		return response;
	}
}
