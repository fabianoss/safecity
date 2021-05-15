package br.com.safecity.repository;

import br.com.safecity.domain.User;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, String> {
	
	@Aggregation(pipeline = { "{$group: { _id: '', total: {$max: $idUser }}}" })
	public Long max();
	
    public User findByIdUser(String idUser);

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
    
    

    
}
