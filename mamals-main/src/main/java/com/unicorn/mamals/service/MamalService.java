package com.unicorn.mamals.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unicorn.mamals.Repository.AnimalDetailsRepository;
import com.unicorn.mamals.model.AnimalDetails;

import antlr.StringUtils;

@Service
public class MamalService {

	@Autowired
	AnimalDetailsRepository animalDetailsRepository;
	
	public ResponseEntity getAnimalDetails(long unicornId) {
		try {
			Optional<AnimalDetails> animalDetails = animalDetailsRepository.findById(unicornId);
			if(animalDetails.isPresent()) {
				return new ResponseEntity(animalDetails.get(), HttpStatus.OK);
			}	
		}catch(Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		return null;
	}

	public ResponseEntity saveAnimalDetails(AnimalDetails animalDetails) {
		
		AnimalDetails response = null;
		Long unicornId = animalDetails.getUnicornId();
		if(animalDetails == null || animalDetails.getUnicornId() == null ) {
			return new ResponseEntity("Invalid Request", HttpStatus.BAD_REQUEST);
		}
		try {
			Optional<AnimalDetails> animalDetailsList = animalDetailsRepository.findById(unicornId);
			if(animalDetailsList.isPresent()) {
				return new ResponseEntity("ID already exsist", HttpStatus.BAD_REQUEST);
			}
			response = animalDetailsRepository.save(animalDetails);
		}catch(Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return new ResponseEntity(response.getUnicornId(), HttpStatus.OK);
	}

	public ResponseEntity updateAnimalDetails(AnimalDetails animalDetails) {
		AnimalDetails response = null;
		Long unicornId = animalDetails.getUnicornId();
		if(animalDetails == null || animalDetails.getUnicornId() == null ) {
			return new ResponseEntity("Invalid Request", HttpStatus.BAD_REQUEST);
		}
		try {
			Optional<AnimalDetails> animalDetailsList = animalDetailsRepository.findById(unicornId);
			if(!animalDetailsList.isPresent()) {
				return new ResponseEntity("ID does not exsist", HttpStatus.BAD_REQUEST);
			}
			response = animalDetailsRepository.save(animalDetails); 
		}catch(Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
}
