package org.ashu.thymeleaf;

import org.ashu.exception.config.CarrierExceptionMapper;
import org.ashu.exception.config.JsonProcessor;
import org.ashu.thymeleaf.utils.ThymeleafPocConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ThymeleafPocConfig {

//	@Autowired
//	private JsonProcessor jsonProcessor ;
	
	@Bean
	public CarrierExceptionMapper getCarrierExceptionMapper() {
		JsonProcessor jsonProcessor = new JsonProcessor(new ObjectMapper());

		final String carrierErrorMappingFileName= ThymeleafPocConstants.ERROR_MAPPING_FILE_NAME;
		return new CarrierExceptionMapper(jsonProcessor, carrierErrorMappingFileName);
	}
}
