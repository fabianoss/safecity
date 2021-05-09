package br.com.safecity.exception;

import java.util.ArrayList;
import java.util.List;

public class CategoriaException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -695011851587361456L;
	
	private List<String> messages = new ArrayList<>();

	public CategoriaException() {
		super();
	}


	public CategoriaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CategoriaException(String message) {
		super(message);
	}

	public CategoriaException(Throwable cause) {
		super(cause);
	}
	
	public CategoriaException(List<String> messages) {
		super();
		this.messages = messages;
	}
	
	public CategoriaException(List<String> messages,Throwable cause) {
		super(cause);
		this.messages = messages;
	}


	public List<String> getMessages() {
		return messages;
	}
	
	
	
	

}
