package br.com.safecity.response;

import br.com.safecity.domain.Endereco;

public class ReclamacaoResponse {

	private Long idReclamacao;
	private String titulo;
	private String descricaoReclamacao;
	private Endereco endereco;

	public Long getIdReclamacao() {
		return idReclamacao;
	}

	public void setIdReclamacao(Long idReclamacao) {
		this.idReclamacao = idReclamacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricaoReclamacao() {
		return descricaoReclamacao;
	}

	public void setDescricaoReclamacao(String descricaoReclamacao) {
		this.descricaoReclamacao = descricaoReclamacao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
