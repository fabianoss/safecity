package br.com.safecity.request;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "enderecoRequest")
public class EnderecoRequest implements Serializable {
	
	private static final long serialVersionUID = -5715110426718390149L;
	
	@JsonProperty(value = "cep")
	private String cep;
	
	@JsonProperty(value = "logradouro")
	private String logradouro;
	
	@JsonProperty(value = "numero")
	private String numero;
	
	@JsonProperty(value = "complemento")
	private String complemento;
	
	@JsonProperty(value = "latitude")
	private BigDecimal latitude;

	@JsonProperty(value = "longitude")
	private BigDecimal longitude;
		
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

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
	
	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
