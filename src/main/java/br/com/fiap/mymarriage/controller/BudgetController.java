package br.com.fiap.mymarriage.controller;

import br.com.fiap.mymarriage.model.Budget;
import br.com.fiap.mymarriage.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "budget")
public class BudgetController {

    @Autowired
    public BudgetService budgetService;

    @GetMapping("/nome/{nome}")
    public Budget buscarNota(@PathVariable(value = "nome") String nome){

        return budgetService.buscarNota(nome);
    }

    @GetMapping()
    public List<Budget> buscarTodos(){
        return budgetService.buscarTodos();
    }

    @DeleteMapping("/nome/{nome}")
    public void apagar(@PathVariable(value = "nome") String nome){
        budgetService.apagar(nome);
    }

    @DeleteMapping()
    public void apagarTodos(){
        budgetService.apagaTodos();
    }

    @PostMapping()
    public void salvar(@RequestBody Budget budget){
        budgetService.save(budget);
    }

}
