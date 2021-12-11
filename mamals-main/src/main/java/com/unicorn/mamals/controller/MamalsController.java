package com.unicorn.mamals.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicorn.mamals.model.AnimalDetails;
import com.unicorn.mamals.service.MamalService;

@RestController
@RequestMapping("/unicorns")
public class MamalsController {
	
	@Autowired
	MamalService mamalService; 
	
	@GetMapping("/{id}")
	public ResponseEntity getUincornDetails(@PathParam("id") long unicornId) {
		return mamalService.getAnimalDetails(unicornId);
	}
	
	@PostMapping
	public ResponseEntity createAnimalDetails(@RequestBody AnimalDetails animalDetails) {
		return mamalService.saveAnimalDetails(animalDetails);
	}
	
	@PutMapping
	public ResponseEntity updateAnimalDetails(@RequestBody AnimalDetails animalDetails) {
		return mamalService.updateAnimalDetails(animalDetails);
	}
	
}
