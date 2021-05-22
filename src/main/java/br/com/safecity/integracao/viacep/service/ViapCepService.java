package br.com.safecity.integracao.viacep.service;

import java.util.IllegalFormatException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.safecity.exception.ViaCepException;
import br.com.safecity.integracao.viacep.response.ViaCepResponse;
import br.com.safecity.utils.JsonUtils;

@Service
public class ViapCepService {

	private static final Logger logger = LoggerFactory.getLogger(ViapCepService.class);

	@Value("${viacep.url}")
	private String urlViapCep;
	
	private RestTemplate restTemplate  =  new RestTemplate();

	public Optional<ViaCepResponse> buscaCep(String cep) throws ViaCepException {
		try {
			return this.findCep(cep);
		} catch (ViaCepException e) {
			return this.findCep(cep);
		}
	}

	private Optional<ViaCepResponse> findCep(String cep) throws ViaCepException {

		try {
			String url = this.urlViapCep;
			url = url+cep+"/json/";
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<>(headers);
			ResponseEntity<ViaCepResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity,
					ViaCepResponse.class);
			JsonUtils.writeValueAsString(responseEntity.getBody());
			return Optional.of(responseEntity.getBody());
		} catch (RestClientException rce) {
			logger.error("Erro geral ao buscar o cep informado! ", rce);
			throw new ViaCepException("Ops não foi possivel consultar o cep informado, tente novamente mais tarde!");
		} catch (IllegalFormatException ife) {
			logger.error("Erro geral url viap cep com problema! {}  error {}", this.urlViapCep,
					ife.getLocalizedMessage(), ife);
			throw new ViaCepException("Ops não foi possivel consultar o cep informado, tente novamente mais tarde!");
		}

	}

}
