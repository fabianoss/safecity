package br.com.safecity.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.safecity.domain.Categoria;
import br.com.safecity.request.CategoriaRequest;
import br.com.safecity.response.CategoriaResponse;

@Mapper
public abstract class CategoriaMapper {

	public static final CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

	public abstract Categoria requestToDomain(CategoriaRequest request);

	@AfterMapping
	public void bindDate(@MappingTarget Categoria domain) {
		domain.setDataAtualizacao(LocalDateTime.now());
		domain.setDataCadastro(LocalDate.now());
	}

	public abstract CategoriaResponse domainToResponse(Categoria domain);

	public abstract List<CategoriaResponse> listDomainToListResponse(List<Categoria> listDomain);

}
