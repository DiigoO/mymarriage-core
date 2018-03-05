package br.com.fiap.mymarriage.repository;

import br.com.fiap.mymarriage.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByNomeAndPassword(String nome, String password);
    User findByNome(String nome);

}
