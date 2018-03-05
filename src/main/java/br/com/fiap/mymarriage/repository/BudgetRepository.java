package br.com.fiap.mymarriage.repository;

import br.com.fiap.mymarriage.model.Budget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends MongoRepository<Budget, String> {
    Budget findByNome(String nome);
}
