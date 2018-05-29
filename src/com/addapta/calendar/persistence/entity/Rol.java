package com.addapta.calendar.persistence.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity

public class Rol {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Para generar números autoincrementados
	private int id;
	private String rol;
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER) //eager = carga ansiosa
	private List<Pagina>listaWeb = new ArrayList<>();
	
	
	public Rol() {
		super();
	this.rol = "user";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



	public String getRol() {
		return rol;
	}



	public void setRol(String rol) {
		this.rol = rol;
	}


	public List<Pagina> getListaWeb() {
		return listaWeb;
	}


	public void setListaWeb(List<Pagina> listaWeb) {
		this.listaWeb = listaWeb;
	}

	
	
}
