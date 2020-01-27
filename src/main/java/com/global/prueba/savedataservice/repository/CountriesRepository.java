package com.global.prueba.savedataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.prueba.savedataservice.entity.CountriesEntity;

public interface CountriesRepository extends JpaRepository<CountriesEntity, Long>{

}
