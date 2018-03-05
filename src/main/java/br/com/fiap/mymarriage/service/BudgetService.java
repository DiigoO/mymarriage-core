package br.com.fiap.mymarriage.service;

import br.com.fiap.mymarriage.model.Budget;
import br.com.fiap.mymarriage.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    @Autowired
    BudgetRepository budgetRepository;

    public void save(Budget budget){
        Budget budgets = budgetRepository.findByNome(budget.getNome());
        if(budgets != null){
            budget.setId(budgets.getId());
        }
        budgetRepository.save(budget);
    }

    public Budget buscarNota(String titulo){
        return budgetRepository.findByNome(titulo);
    }

    public List<Budget> buscarTodos(){
        return budgetRepository.findAll();
    }

    public void apagar(String titulo){
        budgetRepository.delete(titulo);
    }

    public void apagaTodos(){
        budgetRepository.deleteAll();
    }
}
