package br.com.safecity.exception;

import java.util.ArrayList;
import java.util.List;

public class ViaCepException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4554643774092576883L;

	private List<String> messages = new ArrayList<>();

	public ViaCepException() {
		super();
	}

	public ViaCepException(String message, Throwable cause) {
		super(message, cause);
	}

	public ViaCepException(String message) {
		super(message);
	}

	public ViaCepException(Throwable cause) {
		super(cause);
	}

	public ViaCepException(List<String> messages) {
		super();
		this.messages = messages;
	}

	public ViaCepException(List<String> messages, Throwable cause) {
		super(cause);
		this.messages = messages;
	}

	public List<String> getMessages() {
		return messages;
	}

}
