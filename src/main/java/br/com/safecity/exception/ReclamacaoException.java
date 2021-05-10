package br.com.safecity.exception;

import java.util.ArrayList;
import java.util.List;

public class ReclamacaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4554643774092576883L;
	
	private List<String> messages = new ArrayList<>();

	public ReclamacaoException() {
		super();
	}
	
	public ReclamacaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReclamacaoException(String message) {
		super(message);
	}


	public ReclamacaoException(Throwable cause) {
		super(cause);
	}
	
	public ReclamacaoException(List<String> messages) {
		super();
		this.messages = messages;
	}

	public ReclamacaoException(List<String> messages, Throwable cause) {
		super(cause);
		this.messages = messages;
	}

	 public List<String> getMessages() {
		return messages;
	 }
	
}
