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

	@JsonProperty(value = "idCategoria")
	@NotNull(message = "O Identificador de categoria deve ser informado!")
	private Long idCategoria;

	@JsonProperty(value = "titulo")
	@NotNull(message = "O campo título da reclamação deve ser informado!")
	private String titulo;

	@JsonProperty(value = "descricaoReclamacao")
	@NotNull(message = "O campo descrição da reclamação deve ser informado!")
	@NotEmpty(message = "O campo descrição da reclamação deve ser informado!")
	private String descricaoReclamacao;

	@JsonProperty(value = "endereco")
	@NotNull(message = "O campo endereço deve ser informado!")
	private EnderecoRequest endereco;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public EnderecoRequest getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoRequest endereco) {
		this.endereco = endereco;
	}

	public String getDescricaoReclamacao() {
		return descricaoReclamacao;
	}

	public void setDescricaoReclamacao(String descricaoReclamacao) {
		this.descricaoReclamacao = descricaoReclamacao;
	}

}
