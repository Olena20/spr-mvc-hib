package com.sprhib;

import java.io.Serializable;

public class ErrorMessage implements Serializable {
    
	private static final long serialVersionUID = -6422468221552273572L;
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public ErrorMessage () {
		
	}
}
