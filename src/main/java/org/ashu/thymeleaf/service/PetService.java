package org.ashu.thymeleaf.service;

import java.util.ArrayList;
import java.util.List;

import org.ashu.java.api.PetsApiDelegate;
import org.generated.models.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PetService implements PetsApiDelegate {

	@Override
	public ResponseEntity<List<Pet>> listPets(Integer limit) {
		List<Pet> petList = new ArrayList<>();
		Pet pet1 = new Pet();
		pet1.setId(1L);
		pet1.setName("Dog");
		pet1.setTag("Good dog");
		petList.add(pet1);
		return new ResponseEntity<>(petList, HttpStatus.OK);

	}

}