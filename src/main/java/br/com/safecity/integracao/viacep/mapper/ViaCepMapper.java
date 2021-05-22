package br.com.safecity.integracao.viacep.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.safecity.integracao.viacep.dto.ViapCepDto;
import br.com.safecity.integracao.viacep.response.ViaCepResponse;

@Mapper
public interface ViaCepMapper {
	
public static final ViaCepMapper INSTANCE = Mappers.getMapper(ViaCepMapper.class);
	
	public abstract ViapCepDto responseToDto(ViaCepResponse response);

}
