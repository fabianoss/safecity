package br.com.safecity.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.safecity.errors.ErrorDTO;
import br.com.safecity.errors.mapper.ErrorMapper;
import br.com.safecity.exception.ReclamacaoException;
import br.com.safecity.request.ReclamacaoRequest;
import br.com.safecity.response.ReclamacaoResponse;
import br.com.safecity.service.ReclamacaoService;

@RestController
@RequestMapping(name = "/v1/reclamacoes")
public class ReclamacaoController {

	@Autowired
	private ReclamacaoService reclamacaoService;

	@GetMapping(value = "/{idReclamacao}")
	public ResponseEntity<?> one1(@PathVariable Long idReclamacao) {
		Optional<ReclamacaoResponse> optResponse = reclamacaoService.findByReclamacao(idReclamacao);
		if (optResponse.isPresent()) {
			return ResponseEntity.ok(optResponse.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping(value ="/all")
	public ResponseEntity<?> all() throws ReclamacaoException{
		List<ReclamacaoResponse> listResponse = reclamacaoService.findAll();
		if (listResponse != null && !listResponse.isEmpty()) {
			return ResponseEntity.ok(listResponse);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping("/new")
	public ResponseEntity<?> newReclamacao(@Valid @RequestBody ReclamacaoRequest reclamacaoRequest)
			throws ReclamacaoException {
		reclamacaoService.create(reclamacaoRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/{idReclamacao}")
	public ResponseEntity<?> deleteReclamacao1(@PathVariable Long idReclamacao) {
		long result = reclamacaoService.delete(idReclamacao);
		if (result > 0) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PutMapping("/{idReclamacao}")
	public ResponseEntity<?> deleteReclamacao1(@Valid @RequestBody ReclamacaoRequest reclamacaoRequest,
			@PathVariable Long idReclamacao) throws ReclamacaoException {
		reclamacaoService.update(reclamacaoRequest, idReclamacao);
		return ResponseEntity.ok().build();
	}

	@ExceptionHandler(ReclamacaoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorDTO handleReclamacaoException1(ReclamacaoException ex, HttpServletRequest request) {
		ErrorDTO details = ErrorMapper.INSTANCE.toErrorDto(HttpStatus.BAD_REQUEST, "Validation Failed");
		details.setMessage(ex.getLocalizedMessage());
		details.setPath(request.getRequestURI());
		int i = 1;
		for (String message : ex.getMessages()) {
			details.addViolation(String.valueOf(i++), message);
		}
		if (ex.getMessage() != null && !ex.getMessage().isEmpty()) {
			details.addViolation(String.valueOf(i++), ex.getMessage());
		}
		return details;
	}

}
