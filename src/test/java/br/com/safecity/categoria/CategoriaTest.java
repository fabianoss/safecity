package br.com.safecity.categoria;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import br.com.safecity.request.CategoriaRequest;

@SpringBootTest
@AutoConfigureMockMvc
class CategoriaTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@Order(1)
	void categoriaByIdCategoria() throws Exception {
		this.mockMvc.perform(
				get("/v1/categorias/{idCategoria}",5)
				.accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	@Order(2)
	void todasCategoria() throws Exception {		
		this.mockMvc.perform( MockMvcRequestBuilders
				      .get("/v1/categorias")
				      .accept(MediaType.APPLICATION_JSON))
				      .andDo(print())
				      .andExpect(status().is2xxSuccessful());
	}

	@Test
	@Order(3)
	void novaCategoria() throws Exception {
		this.mockMvc.perform(
				post("/v1/categorias")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new CategoriaRequest(randomString()))))
				.andExpect(status().isCreated());
	}
	
	@Test
	@Order(4)
	void atualizaCategoria() throws Exception {
		this.mockMvc.perform(
				put("/v1/categorias/{idCategoria}",6)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new CategoriaRequest(randomString()))))
				.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	@Order(5)
	void excluiCategoria() throws Exception {
		this.mockMvc.perform(
				delete("/v1/categorias/{idCategoria}",5)
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

}
