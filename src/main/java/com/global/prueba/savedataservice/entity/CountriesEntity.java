package com.global.prueba.savedataservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRIES")
public class CountriesEntity {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;
	@Column
	private String capital;
	@Column
	private String cioc;
	
	public CountriesEntity(String name, String capital, String cioc) {
		super();
		this.name = name;
		this.capital = capital;
		this.cioc = cioc;
	}
	
	@Override
	public String toString() {
		return "CountriesEntity [name=" + name + ", capital=" + capital + ", cioc=" + cioc + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getCioc() {
		return cioc;
	}

	public void setCioc(String cioc) {
		this.cioc = cioc;
	}
	
}
