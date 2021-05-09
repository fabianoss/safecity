package br.com.safecity.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "categoria")
public class Categoria extends BaseDocument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7225903048926196321L;

	@Field(name = "idCategoria")
	@Indexed(unique = true)
	private Long idCategoria;

	@Field(name = "descricaoCategoria")
	@Indexed(unique = true)
	private String descricaoCategoria;

	@Field(name = "dataCadastro")
	private LocalDate dataCadastro;

	@Field(name = "dataAtualizacao")
	private LocalDateTime dataAtualizacao;

	@Field(name = "usuarioAtualizacao")
	private String usuarioAtualizacao;

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getUsuarioAtualizacao() {
		return usuarioAtualizacao;
	}

	public void setUsuarioAtualizacao(String usuarioAtualizacao) {
		this.usuarioAtualizacao = usuarioAtualizacao;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
