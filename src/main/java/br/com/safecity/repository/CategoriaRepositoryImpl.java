package br.com.safecity.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.DeleteResult;

import br.com.safecity.domain.Categoria;

@Repository
public class CategoriaRepositoryImpl implements ICategoriaCustomRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public long deleteByIdCategoria(Long idCategoria) {
		DeleteResult result = mongoTemplate.remove(
					new Query(
							Criteria.where("idCategoria").is(idCategoria)), Categoria.class);
		return result.getDeletedCount();
	}

}
