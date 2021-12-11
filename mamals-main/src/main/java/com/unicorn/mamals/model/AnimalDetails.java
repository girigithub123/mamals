package com.unicorn.mamals.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class AnimalDetails implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unicornId;
	private String name;
	private String hairColor;
	private String eyeColor;
	private String heightUnit;
	private String weightUnit;
	private int hornLength;
	private int height;
	private int weight;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "animalDetails")
    private Set<IdentificationMarks> identificationMarks;
	
	public Long getUnicornId() {
		return unicornId;
	}

	public void setUnicornId(Long unicornId) {
		this.unicornId = unicornId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getHeightUnit() {
		return heightUnit;
	}

	public void setHeightUnit(String heightUnit) {
		this.heightUnit = heightUnit;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public int getHornLength() {
		return hornLength;
	}

	public void setHornLength(int hornLength) {
		this.hornLength = hornLength;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Set<IdentificationMarks> getIdentificationMarks() {
		return identificationMarks;
	}

	public void setIdentificationMarks(Set<IdentificationMarks> identificationMarks) {
		this.identificationMarks = identificationMarks;
	}

}
