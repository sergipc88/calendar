package com.addapta.calendar.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pagina {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Para generar números autoincrementados
	private int id;
	private String NombrePagina;
	
	
	public Pagina() {
		super();
		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrePagina() {
		return NombrePagina;
	}

	public void setNombrePagina(String nombrePagina) {
		NombrePagina = nombrePagina;
	}
	
	
	
	
	
}
