package br.com.safecity.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.client.result.DeleteResult;

import br.com.safecity.domain.Reclamacao;

public class ReclamacaoRepositoryImpl implements IReclamacaoCustomRepository{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public long deleteByIdReclamacao(Long idReclamacao) {
		DeleteResult result = mongoTemplate.remove(
				new Query(
					Criteria.where("idReclamacao").is(idReclamacao)), Reclamacao.class);					
		return result.getDeletedCount();		
	}

}
