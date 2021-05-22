package br.com.safecity.reclamacao;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.safecity.request.EnderecoRequest;
import br.com.safecity.request.ReclamacaoRequest;

@SpringBootTest
@AutoConfigureMockMvc
class ReclamacaoTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@Order(1)
	void reclamacaoByIdReclamacao() throws Exception {
		this.mockMvc.perform(
				get("/v1/reclamacoes/{idReclamacao}",5)
				.accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	@Order(2)
	void todasReclamacoes() throws Exception {		
		this.mockMvc.perform( MockMvcRequestBuilders
				      .get("/v1/reclamacoes")
				      .accept(MediaType.APPLICATION_JSON))
				      .andDo(print())
				      .andExpect(status().is2xxSuccessful());
	}

	@Test
	@Order(3)
	void novaReclamacao() throws Exception {
		this.mockMvc.perform(
				post("/v1/reclamacoes")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(bindReclamacao())))
				.andExpect(status().isCreated());
	}
	
	@Test
	@Order(4)
	void atualizaReclamacao() throws Exception {
		this.mockMvc.perform(
				put("/v1/reclamacoes/{idReclamacao}",4)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(bindReclamacao())))
				.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	@Order(5)
	void excluiReclamacao() throws Exception {
		this.mockMvc.perform(
				delete("/v1/reclamacoes/{idReclamacao}",5)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful());
	}
	
	static String asJsonString(final Object obj) {
	    try {
	    	String json = new ObjectMapper().writeValueAsString(obj);
	    	return json;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	
	static String randomString() {
		String texto = null;
		try {
			int length = 10;
			boolean useLetters = true;
			boolean useNumbers = false;
			texto = RandomStringUtils.random(length, useLetters, useNumbers);			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return texto;
		
	}
	 static ReclamacaoRequest bindReclamacao() {
		 ReclamacaoRequest reclamacaoRequest = new ReclamacaoRequest();
		 reclamacaoRequest.setIdCategoria(7L);
		 reclamacaoRequest.setTitulo(randomString());
		 reclamacaoRequest.setDescricaoReclamacao(randomString());
		 EnderecoRequest enderecoRequest = new EnderecoRequest();
		 enderecoRequest.setCep("19600000");
		 enderecoRequest.setComplemento(randomString());
		 enderecoRequest.setLogradouro(randomString());
		 enderecoRequest.setNumero(randomString());
		 enderecoRequest.setLongitude(new BigDecimal("-32.000000"));
		 enderecoRequest.setLatitude(new BigDecimal("-32.000000"));
		 reclamacaoRequest.setEndereco(enderecoRequest);		 
		 return reclamacaoRequest;
	 }

}
