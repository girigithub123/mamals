package com.unicorn.mamals.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IdentificationMarks {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificationid; 
	private String side;
	private String location;
	private String mark;
	private String color;
	@ManyToOne
	@JoinColumn(name="unicorn_Id")
	private AnimalDetails animalDetails;
	
	public Long getIdentificationid() {
		return identificationid;
	}

	public void setIdentificationid(Long identificationid) {
		this.identificationid = identificationid;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public AnimalDetails getAnimalDetails() {
		return animalDetails;
	}

	public void setAnimalDetails(AnimalDetails animalDetails) {
		this.animalDetails = animalDetails;
	}

}
