package br.com.safecity.repository;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.safecity.domain.Reclamacao;

@Repository("reclamacaoRepository")
public interface IReclamacaoRepository extends CrudRepository<Reclamacao, String>,IReclamacaoCustomRepository {

	
	@Aggregation(pipeline = { "{$group: { _id: '', total: {$max: $idReclamacao }}}"})
	public Long max();
	
	public Reclamacao findByIdReclamacao(Long idReclamacao);

	
}
