package br.com.safecity.repository;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.safecity.domain.Categoria;

@Repository("categoriaRepository")
public interface ICategoriaRepository extends CrudRepository<Categoria, String>,ICategoriaCustomRepository{
	
	@Aggregation(pipeline = { "{$group: { _id: '', total: {$max: $idCategoria }}}" })
	public Long max();
	
	public Categoria findByIdCategoria(Long idCategoria);
	

}
