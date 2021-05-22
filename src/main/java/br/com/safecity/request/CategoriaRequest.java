package br.com.safecity.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "categoriaRequest")
public class CategoriaRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 785720877188849039L;
	@JsonProperty(value = "descricaoCategoria")
	@NotNull(message = "O campo descrição da categoria deve ser informado!")
	@NotEmpty(message = "O campo descrição da categoria deve ser informado!")
	private String descricaoCategoria;
	
	

	public CategoriaRequest(
			@NotNull(message = "O campo descrição da categoria deve ser informado!") 
			@NotEmpty(message = "O campo descrição da categoria deve ser informado!") 
			String descricaoCategoria) {
		super();
		this.descricaoCategoria = descricaoCategoria;
	}

	public CategoriaRequest() {
		super();
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

}
