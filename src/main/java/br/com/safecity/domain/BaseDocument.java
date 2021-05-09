package br.com.safecity.domain;

import org.springframework.data.annotation.Id;

public abstract class BaseDocument {

	@Id
	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
