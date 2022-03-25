package org.ashu.thymeleaf.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.ashu.exception.config.CarrierExceptionMapper;
import org.ashu.java.api.PetApiDelegate;
import org.ashu.thymeleaf.config.TemplateProcessor;
import org.ashu.validation.util.JsonProcessor;
import org.generated.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import io.swagger.models.HttpMethod;

@Service
public class PetService implements PetApiDelegate {

	@Autowired
	private JsonProcessor jsonProcessor;

	@Autowired
	private TemplateProcessor templateProcessor;

	@Autowired
	private ThymeleafExceptionService thymeleafExceptionService;
	
	@Value("${product.pet.url}")
	private String petUrl;
	
	@Override
	public ResponseEntity<List<Pet>> getAllPetsUsingGET(Integer page, Integer size, String sort) {
		String response = this.templateProcessor.processTemplate(new HashMap<String, Object>(), "getPetRequest");
		List<Pet> pets = jsonProcessor.readValue(response, new TypeReference<List<Pet>>() {
		});
		return new ResponseEntity<>(pets, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Pet> addPetUsingPOST(@NotNull Pet pet) {
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<Pet> updatePetUsingPUT(Pet pet) {
		Map<String, Object> map = new HashMap<>();
		map.put("petFromUI", jsonProcessor.toJsonString(pet));
		String response = this.templateProcessor.processTemplate(map, "putPetRequest");
		//Throw error
		thymeleafExceptionService.createException(petUrl,HttpMethod.PUT.toString() , "Invalid Pet Info");
		
		Pet updatedPet = jsonProcessor.readValue(response, Pet.class);
		return new ResponseEntity<>(updatedPet,HttpStatus.OK);
	}
}