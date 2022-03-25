package org.ashu.thymeleaf.service;

import org.ashu.exception.config.CarrierExceptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ThymeleafExceptionService {

	@Autowired
	private CarrierExceptionMapper carrierExceptionMapper;
	
	@Value("${product.name}")
	private  String productName;


	
	public void createException(String url, String httpMethod ,String errorMessage) {
		carrierExceptionMapper.mapAndThrowBrokerException(url, httpMethod , productName , HttpStatus.BAD_REQUEST.value(), "Invalid Pet Info");
	}

	
}
