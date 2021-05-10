package br.com.safecity.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

	@Field(name = "descricaoReclamacao")
	private String descricaoReclamacao;

	@Field(name = "dataCadastro")
	private LocalDate dataCadastro;

	@Field(name = "endereco")
	private Endereco endereco;

	@Field(name = "dataAtualizacao")
	private LocalDateTime dataAtualizacao;

	@Field(name = "usuarioAtualizacao")
	private String usuarioAtualizacao;

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

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescricaoReclamacao() {
		return descricaoReclamacao;
	}

	public void setDescricaoReclamacao(String descricaoReclamacao) {
		this.descricaoReclamacao = descricaoReclamacao;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
