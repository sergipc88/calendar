package com.addapta.calendar.persistence.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Cita {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Para generar números autoincrementados
	private int id;
	private Date fechaInicio;
	private Date fechaFin;
	private String descripcion;
	private Date horaInit;
	private Date horaFin;
	@OneToOne
	private Calendario c;
	
	public Cita() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Date getHoraInit() {
		return horaInit;
	}



	public void setHoraInit(Date horaInit) {
		this.horaInit = horaInit;
	}



	public Date getHoraFin() {
		return horaFin;
	}



	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}



	public Calendario getC() {
		return c;
	}



	public void setC(Calendario c) {
		this.c = c;
	}
	
	
	
	
	
	
	
}
