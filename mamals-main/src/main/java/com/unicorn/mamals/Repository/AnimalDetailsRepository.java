package com.unicorn.mamals.Repository;

import org.springframework.stereotype.Repository;

import com.unicorn.mamals.model.AnimalDetails;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AnimalDetailsRepository extends JpaRepository<AnimalDetails, Long>{

}
