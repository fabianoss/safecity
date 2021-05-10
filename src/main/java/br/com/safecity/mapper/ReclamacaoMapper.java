package br.com.safecity.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.safecity.domain.Reclamacao;
import br.com.safecity.request.ReclamacaoRequest;
import br.com.safecity.response.ReclamacaoResponse;

@Mapper
public abstract class ReclamacaoMapper {

	public static final ReclamacaoMapper INSTANCE = Mappers.getMapper(ReclamacaoMapper.class);
	
	public abstract Reclamacao requestToDomain(ReclamacaoRequest request);
	
	@AfterMapping
	public void bindDate(@MappingTarget Reclamacao domain) {
		domain.setDataAtualizacao(LocalDateTime.now());
		domain.setDataCadastro(LocalDate.now());
	}
	
	public abstract ReclamacaoResponse domainToResponse(Reclamacao domain);
	
	public abstract List<ReclamacaoResponse> listDomainToListResponse(List<Reclamacao> listDomain);
	
}
