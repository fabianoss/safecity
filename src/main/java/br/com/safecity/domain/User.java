package br.com.safecity.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "user")
public class User extends BaseDocument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Field(name = "idUser")
	@Indexed(unique = true)
	private Long idUser;

	@Field(name = "name")
	private String name;

	@Field(name = "email")
	private String email;

	@Field(name = "imageUrl")
	private String imageUrl;

	@Field(name = "emailVerified")
	private Boolean emailVerified = false;

	@Field(name = "password")
	private String password;

	@Field(name = "provider")
	private AuthProvider provider;

	@Field(name = "providerId")
	private String providerId;



	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthProvider getProvider() {
		return provider;
	}

	public void setProvider(AuthProvider provider) {
		this.provider = provider;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}