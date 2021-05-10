package br.com.safecity.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.safecity.domain.Reclamacao;
import br.com.safecity.exception.ReclamacaoException;
import br.com.safecity.mapper.ReclamacaoMapper;
import br.com.safecity.repository.IReclamacaoRepository;
import br.com.safecity.request.ReclamacaoRequest;
import br.com.safecity.response.ReclamacaoResponse;

@Service
@Validated
public class ReclamacaoService {

	@Autowired
	private IReclamacaoRepository reclamacaoRepository;

	public Optional<ReclamacaoResponse> findByReclamacao(Long idReclamacao) throws ReclamacaoException {
		return Optional.ofNullable(
				ReclamacaoMapper.INSTANCE.domainToResponse(reclamacaoRepository.findByIdReclamacao(idReclamacao)));
	}

	public List<ReclamacaoResponse> findAll() throws ReclamacaoException {
		Iterable<Reclamacao> it = reclamacaoRepository.findAll();
		return ReclamacaoMapper.INSTANCE
				.listDomainToListResponse(StreamSupport.stream(it.spliterator(), false).collect(Collectors.toList()));
	}

	public void create(@Valid ReclamacaoRequest reclamacaoRequest) throws ReclamacaoException {
		Reclamacao reclamacao = ReclamacaoMapper.INSTANCE.requestToDomain(reclamacaoRequest);
		reclamacao.setIdReclamacao(this.maxReclamacao());
		reclamacaoRepository.save(reclamacao);
		
	}

	public long delete(Long idReclamacao) throws ReclamacaoException {
		return reclamacaoRepository.deleteByIdReclamacao(idReclamacao);
	}
	
	public void update(@Valid ReclamacaoRequest request, Long idReclamacao) throws ReclamacaoException {
		Reclamacao reclamacao = reclamacaoRepository.findByIdReclamacao(idReclamacao);
		if(reclamacao == null) {
			throw new ReclamacaoException("Reclamacao não encontrada para o id informado!");
		}
		reclamacao.setDescricaoReclamacao(request.getDescricaoReclamacao());
		reclamacao.setDataAtualizacao(LocalDateTime.now());
		reclamacaoRepository.save(reclamacao);
	}
	
	private Long maxReclamacao() {
		Long idReclamacao = reclamacaoRepository.max();
		return (idReclamacao != null ? ++idReclamacao : 1L);
	}
	
}
