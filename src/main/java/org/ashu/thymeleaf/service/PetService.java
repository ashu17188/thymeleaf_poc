package org.ashu.thymeleaf.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.ashu.java.api.ApiUtil;
import org.ashu.java.api.PetApiDelegate;
import org.generated.models.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PetService implements PetApiDelegate {

	
	@Override
	public ResponseEntity<List<Pet>> getAllPetsUsingGET(Integer page,
      Integer size,
      String sort) {
      getRequest().ifPresent(request -> {
          for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
              if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                  String exampleString = "{ \"photoUrls\" : [ \"photoUrls\", \"photoUrls\" ], \"name\" : \"doggie\", \"id\" : 10, \"category\" : { \"name\" : \"Dogs\", \"id\" : 1 }, \"status\" : \"available\", \"tags\" : [ { \"name\" : \"name\", \"id\" : 0 }, { \"name\" : \"name\", \"id\" : 0 } ] }";
                  ApiUtil.setExampleResponse(request, "application/json", exampleString);
                  break;
              }
          }
      });
      return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

	@Override
	public ResponseEntity<Pet> addPetUsingPOST(@NotNull Pet pet) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					String exampleString = "{ \"photoUrls\" : [ \"photoUrls\", \"photoUrls\" ], \"name\" : \"doggie\", \"id\" : 10, \"category\" : { \"name\" : \"Dogs\", \"id\" : 1 }, \"status\" : \"available\", \"tags\" : [ { \"name\" : \"name\", \"id\" : 0 }, { \"name\" : \"name\", \"id\" : 0 } ] }";
					ApiUtil.setExampleResponse(request, "application/json", exampleString);
					break;
				}
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
					String exampleString = "<Pet> <id>10</id> <name>doggie</name> <photoUrls>aeiou</photoUrls> <status>aeiou</status> </Pet>";
					ApiUtil.setExampleResponse(request, "application/xml", exampleString);
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<Pet> updatePetUsingPUT(Pet pet) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					String exampleString = "{ \"photoUrls\" : [ \"photoUrls\", \"photoUrls\" ], \"name\" : \"doggie\", \"id\" : 10, \"category\" : { \"name\" : \"Dogs\", \"id\" : 1 }, \"status\" : \"available\", \"tags\" : [ { \"name\" : \"name\", \"id\" : 0 }, { \"name\" : \"name\", \"id\" : 0 } ] }";
					ApiUtil.setExampleResponse(request, "application/json", exampleString);
					break;
				}
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
					String exampleString = "<null> <id>10</id> <name>doggie</name> <photoUrls>aeiou</photoUrls> <status>aeiou</status> </null>";
					ApiUtil.setExampleResponse(request, "application/xml", exampleString);
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.OK);

	}
}