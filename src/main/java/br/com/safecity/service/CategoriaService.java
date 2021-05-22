package br.com.safecity.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.safecity.domain.Categoria;
import br.com.safecity.exception.CategoriaException;
import br.com.safecity.mapper.CategoriaMapper;
import br.com.safecity.repository.ICategoriaRepository;
import br.com.safecity.request.CategoriaRequest;
import br.com.safecity.response.CategoriaResponse;

@Service
@Validated
public class CategoriaService {

	private static final Logger logger = LoggerFactory.getLogger(CategoriaService.class);
	
	
	@Autowired
	private ICategoriaRepository categoriaRepository;

	public Optional<CategoriaResponse> findByCategoria(Long idCategoria) throws CategoriaException {
		return Optional.ofNullable(
				CategoriaMapper.INSTANCE.domainToResponse(categoriaRepository.findByIdCategoria(idCategoria)));

	}

	public List<CategoriaResponse> findAll() throws CategoriaException {
		Iterable<Categoria> it = categoriaRepository.findAll();
		return CategoriaMapper.INSTANCE
				.listDomainToListResponse(StreamSupport.stream(it.spliterator(), false).collect(Collectors.toList()));
	}

	public void create(@Valid CategoriaRequest request) throws CategoriaException {
		Categoria categoria = CategoriaMapper.INSTANCE.requestToDomain(request);
		categoria.setIdCategoria(this.maxCategoria());
		categoriaRepository.save(categoria);

	}
	
	public long delete(Long idCategoria) throws CategoriaException {
		return categoriaRepository.deleteByIdCategoria(idCategoria);
	}
	
	public void update(@Valid CategoriaRequest request,Long idCategoria) throws CategoriaException {
		Categoria categoria = categoriaRepository.findByIdCategoria(idCategoria);
		if(categoria == null) {		
			throw new CategoriaException("Categoria não encontrada para o id informado!");
		}
		categoria.setDescricaoCategoria(request.getDescricaoCategoria());
		categoria.setDataAtualizacao(LocalDateTime.now());
		categoriaRepository.save(categoria);
	}

	private Long maxCategoria() {
		Long idCategoria = 0L;
	
		try {
			idCategoria = categoriaRepository.max();			
		}catch (Exception e) {
			logger.error("error maxCategoria {} ",e.getLocalizedMessage(),e);
		}	
		return (idCategoria != null ? ++idCategoria : 1L);
	}
	
	
}
