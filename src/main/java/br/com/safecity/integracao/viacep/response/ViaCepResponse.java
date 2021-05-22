package br.com.safecity.integracao.viacep.response;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViaCepResponse implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -5075938394032962493L;
	@JsonProperty("cep")
	private String cep;
	@JsonProperty("logradouro")
	private String logradouro;
	@JsonProperty("complemento")
	private String complemento;
	@JsonProperty("bairro")
	private String bairro;
	@JsonProperty("localidade")
	private String localidade;
	@JsonProperty("uf")
	private String uf;
	@JsonProperty("ibge")
	private String ibge;
	@JsonProperty("gia")
	private String gia;
	@JsonProperty("ddd")
	private String ddd;
	@JsonProperty("siafi")
	private String siafi;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getSiafi() {
		return siafi;
	}

	public void setSiafi(String siafi) {
		this.siafi = siafi;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
