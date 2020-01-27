package com.global.prueba.savedataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.global.prueba.savedataservice.entity.CountriesEntity;
import com.global.prueba.savedataservice.repository.CountriesRepository;
import com.google.gson.Gson;

@RestController
@RequestMapping(path = "/countries")
public class CountriesController {
	
	@Autowired
	private CountriesRepository countriesRepository;

	@GetMapping
	public ResponseEntity<Object> save() throws JsonMappingException, JsonProcessingException {
		// 1. El servicio
		// http://jsonverserverclever.azurewebsites.net/LicensePlate
		// definido en el ejercicio no retorna resultados
		// 2. Se define como prueba consultar un servicio que retorna países
		Object responseObject = new RestTemplate().getForObject("https://restcountries.eu/rest/v2/lang/es",
				Object.class);

		Gson gson = new Gson();
		// Del resultado del servicio se obtiene el json
		String jsonResponse = gson.toJson(responseObject);
		// Convertir el json en objeto java
		CountriesEntity[] countriesArray = gson.fromJson(jsonResponse, CountriesEntity[].class);
		if(countriesArray != null && countriesArray.length > 0){
			// Recorrer el array para guardar
			for (CountriesEntity country : countriesArray) {
				countriesRepository.save(country);
			}
		}
		
		return ResponseEntity.ok().build();
	}

}
