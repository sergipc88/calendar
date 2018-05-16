package com.addapta.calendar.getway.dto;

import java.io.Serializable;

public class DtoNombrerepetido implements Serializable {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean success;
	private boolean isRepeated;
	private int[] errores;
	
	
	public DtoNombrerepetido() {
		super();
		
		this.success = false;
		this.isRepeated = false;
		this.errores = new int[0];
		// TODO Auto-generated constructor stub
	}

	
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	public boolean isRepeated() {
		return isRepeated;
	}
	public void setRepeated(boolean isRepeated) {
		this.isRepeated = isRepeated;
	}
	public int[] getErrores() {
		return errores;
	}
	public void setErrores(int[] errores) {
		this.errores = errores;
	}
	
	

}
