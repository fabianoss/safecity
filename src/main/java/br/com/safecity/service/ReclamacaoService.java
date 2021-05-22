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

import br.com.safecity.domain.Reclamacao;
import br.com.safecity.exception.CategoriaException;
import br.com.safecity.exception.ReclamacaoException;
import br.com.safecity.exception.ViaCepException;
import br.com.safecity.integracao.viacep.response.ViaCepResponse;
import br.com.safecity.integracao.viacep.service.ViapCepService;
import br.com.safecity.mapper.ReclamacaoMapper;
import br.com.safecity.repository.IReclamacaoRepository;
import br.com.safecity.request.ReclamacaoRequest;
import br.com.safecity.response.CategoriaResponse;
import br.com.safecity.response.ReclamacaoResponse;

@Service
@Validated
public class ReclamacaoService {

	private static final Logger logger = LoggerFactory.getLogger(ReclamacaoService.class);

	@Autowired
	private ViapCepService viapCepService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private IReclamacaoRepository reclamacaoRepository;

	public Optional<ReclamacaoResponse> findByReclamacao(Long idReclamacao) throws ReclamacaoException {
		return Optional.ofNullable(
				ReclamacaoMapper.INSTANCE.domainToResponse(reclamacaoRepository.findByIdReclamacao(idReclamacao)));
	}

	public List<ReclamacaoResponse> buscaTodasReclamacoes() throws ReclamacaoException {
		Iterable<Reclamacao> it = reclamacaoRepository.findAll();
		return ReclamacaoMapper.INSTANCE
				.listDomainToListResponse(StreamSupport.stream(it.spliterator(), false).collect(Collectors.toList()));
	}

	public void novaReclamacao(@Valid ReclamacaoRequest reclamacaoRequest) throws ReclamacaoException {
		this.createReclamacao(reclamacaoRequest);
	}

	public long excluiReclamacao(Long idReclamacao) throws ReclamacaoException {
		return reclamacaoRepository.deleteByIdReclamacao(idReclamacao);
	}

	public void atualizaReclamacao(@Valid ReclamacaoRequest request, Long idReclamacao) throws ReclamacaoException {
		Reclamacao reclamacao = reclamacaoRepository.findByIdReclamacao(idReclamacao);
		if (reclamacao == null) {
			throw new ReclamacaoException("Reclamacao não encontrada para o id informado!");
		}
		reclamacao.setDescricaoReclamacao(request.getDescricaoReclamacao());
		reclamacao.setDataAtualizacao(LocalDateTime.now());
		reclamacaoRepository.save(reclamacao);
	}

	private Long maxReclamacao() {
		Long idReclamacao = 0L;
		try {
			idReclamacao = reclamacaoRepository.max();
		} catch (Exception e) {
			logger.error("error maxCategoria {} ", e.getLocalizedMessage(), e);
		}
		return (idReclamacao != null ? ++idReclamacao : 1L);
	}

	private void createReclamacao(ReclamacaoRequest request) {		
		Optional<CategoriaResponse> optCategoria = this.findByCategoria(request);
		Optional<ViaCepResponse> optCep = this.findCep(request);
		Reclamacao reclamacao = ReclamacaoMapper.INSTANCE.requestToDomain(request, optCep.get(), optCategoria.get());
		reclamacao.setIdReclamacao(this.maxReclamacao());
		reclamacaoRepository.save(reclamacao);
	}

	private Optional<ViaCepResponse> findCep(ReclamacaoRequest request) throws ReclamacaoException {
		Optional<ViaCepResponse> opt = Optional.empty();
		try {
			opt = viapCepService.buscaCep(request.getEndereco().getCep());
		} catch (ViaCepException e) {
			throw new ReclamacaoException("Ops erro ao validar o cep, tente novamente mais tarde", e);
		}
		if (opt.isEmpty()) {
			throw new ReclamacaoException(
					"Ops desculpe não conseguimos validar o cep informado, por favor poderia utilizar um valido?");
		}
		return opt;
	}

	private Optional<CategoriaResponse> findByCategoria(ReclamacaoRequest request) throws ReclamacaoException {
		Optional<CategoriaResponse> opt = Optional.empty();
		try {
			opt = categoriaService.findByCategoria(request.getIdCategoria());
		} catch (CategoriaException e) {
			throw new ReclamacaoException(
					"Ops desculpe não conseguimos validar a categoria informada, tente novamente mais tarde");
		}

		if (opt.isEmpty()) {
			throw new ReclamacaoException(
					"Ops desculpe não conseguimos a categoria informada, tente novamente mais tarde");
		}

		return opt;
	}

}
