package br.com.safecity.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "reclamacaoRequest")
public class ReclamacaoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4936020176617495438L;
	@JsonProperty(value = "descricaoReclamacao")
	@NotNull(message = "O campo descrição da reclamação deve ser informado!")
	@NotEmpty(message = "O campo descrição da reclamação deve ser informado!")
	private String descricaoReclamacao;

	public String getDescricaoReclamacao() {
		return descricaoReclamacao;
	}

	public void setDescricaoReclamacao(String descricaoReclamacao) {
		this.descricaoReclamacao = descricaoReclamacao;
	}

}
