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
import br.com.safecity.exception.CategoriaException;
import br.com.safecity.request.CategoriaRequest;
import br.com.safecity.response.CategoriaResponse;
import br.com.safecity.service.CategoriaService;

@RestController
@RequestMapping(value =  "/v1/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping(value = "/{idCategoria}")
	public ResponseEntity<CategoriaResponse> categoriaByIdCategoria(@PathVariable Long idCategoria) throws CategoriaException {
		Optional<CategoriaResponse> optResponse = categoriaService.findByCategoria(idCategoria);
		if (optResponse.isPresent()) {
			return ResponseEntity.ok(optResponse.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<CategoriaResponse>> todasCategorias() throws CategoriaException {
		List<CategoriaResponse> listResponse = categoriaService.findAll();
		if (listResponse != null && !listResponse.isEmpty()) {
			return ResponseEntity.ok(listResponse);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping
	public ResponseEntity<CategoriaResponse> novaCategoria(@Valid @RequestBody CategoriaRequest categoriaRequest)
			throws CategoriaException {
		categoriaService.create(categoriaRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping(value = "/{idCategoria}")
	public ResponseEntity<Void> atualizaCategoria(@Valid @RequestBody CategoriaRequest categoriaRequest,
			@PathVariable Long idCategoria) throws CategoriaException {
		categoriaService.update(categoriaRequest, idCategoria);
		return ResponseEntity.ok().build();

	}
	
	@DeleteMapping(value = "/{idCategoria}")
	public ResponseEntity<Void> excluiCategoria(@PathVariable Long idCategoria) throws CategoriaException {
		long result = categoriaService.delete(idCategoria);
		if (result > 0) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@ExceptionHandler(CategoriaException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorDTO handleCategoriaException(CategoriaException ex, HttpServletRequest request) {
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
