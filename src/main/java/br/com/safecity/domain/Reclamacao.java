package br.com.safecity.domain;

import java.io.Serializable;
import java.time.LocalDate;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "reclamacao")
public class Reclamacao extends BaseDocument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8073574692157208057L;

	@Field(name = "idReclamacao")
	private Long idReclamacao;
	
	@Field(name = "titulo")
	private String titulo;

	@Field(name = "idCategoria")
	private Long idCategoria;

	@Field(name = "dataCadastro")
	private LocalDate dataCadastro;

	@Field(name = "endereco")
	private Endereco endereco;

	@Field(name = "dataAtualizacao")
	private LocalDate dataAtualizacao;

	@Field(name = "usuarioAtualizacao")
	private String usuarioAtualizacao;

	public Long getIdReclamacao() {
		return idReclamacao;
	}

	public void setIdReclamacao(Long idReclamacao) {
		this.idReclamacao = idReclamacao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getUsuarioAtualizacao() {
		return usuarioAtualizacao;
	}

	public void setUsuarioAtualizacao(String usuarioAtualizacao) {
		this.usuarioAtualizacao = usuarioAtualizacao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
