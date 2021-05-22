package br.com.safecity.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import br.com.safecity.domain.Reclamacao;
import br.com.safecity.integracao.viacep.response.ViaCepResponse;
import br.com.safecity.request.ReclamacaoRequest;
import br.com.safecity.response.CategoriaResponse;
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
	
	@Mappings({
		@Mapping(source ="categoria.idCategoria",target ="idCategoria"),
		@Mapping(source ="cep.cep",target="endereco.cep"),
		@Mapping(source ="cep.logradouro",target="endereco.logradouro"),
		@Mapping(source ="cep.complemento",target="endereco.complemento"),
		@Mapping(source ="cep.bairro",target="endereco.bairro"),
		@Mapping(source ="cep.localidade",target="endereco.localidade"),
		@Mapping(source ="cep.uf",target="endereco.uf"),
		@Mapping(source ="cep.ibge",target="endereco.ibge"),
		@Mapping(source ="cep.gia",target="endereco.gia"),
		@Mapping(source ="cep.ddd",target="endereco.ddd"),
		@Mapping(source ="cep.siafi",target="endereco.siafi"),		
		@Mapping(source ="request.endereco.latitude",target="endereco.latitude"),
		@Mapping(source ="request.endereco.longitude",target="endereco.longitude"),
		@Mapping(target="id",ignore = true),
		@Mapping(target="dataAtualizacao",ignore = true), 
		@Mapping(target="dataCadastro",ignore = true),
		@Mapping(target="idReclamacao",ignore = true),
		@Mapping(target="usuarioAtualizacao",ignore = true)
	})
	public abstract Reclamacao requestToDomain(ReclamacaoRequest request,ViaCepResponse cep, CategoriaResponse categoria);
	
	@AfterMapping
	public void bindDateDomain(@MappingTarget Reclamacao domain,ReclamacaoRequest request,ViaCepResponse cep) {
		domain.setDataCadastro(LocalDate.now());
		domain.setDataCadastro(LocalDate.now());
		if(request.getEndereco().getLogradouro() != null && !request.getEndereco().getLogradouro().isEmpty()) {
			domain.getEndereco().setLogradouro(cep.getLogradouro());
		}
	}


}
