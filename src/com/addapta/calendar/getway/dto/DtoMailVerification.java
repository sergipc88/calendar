package com.addapta.calendar.getway.dto;

import java.io.Serializable;

public class DtoMailVerification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean success;
	private boolean isRepeated;
	private boolean wrongFormat;
	private int[] errores;
	
	public DtoMailVerification() {
		super();
		
		this.success = false;
		this.isRepeated = false;
		this.wrongFormat = false;
		this.errores = new int[0];
		
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

	public boolean isWrongFormat() {
		return wrongFormat;
	}

	public void setWrongFormat(boolean wrongFormat) {
		this.wrongFormat = wrongFormat;
	}

	public int[] getErrores() {
		return errores;
	}

	public void setErrores(int[] errores) {
		this.errores = errores;
	}
	
	

	
}
