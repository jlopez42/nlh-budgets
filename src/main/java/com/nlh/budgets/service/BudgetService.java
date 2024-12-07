package com.nlh.budgets.service;

import com.nlh.budgets.model.Budget;
import com.nlh.budgets.payloads.request.BudgetRequest;
import com.nlh.budgets.payloads.response.BudgetResponse;
import com.nlh.budgets.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository repository;

    public BudgetService(BudgetRepository repository) {
        this.repository = repository;
    }
    public BudgetResponse newProject(BudgetRequest request){

        if(repository.existsByProjectId(request.getBudget().getProjectId())){
            Budget budget = repository.save(request.getBudget());
            return new BudgetResponse("Budget has associated to project successfully",
                    "201",
                    budget.getId(),
                    budget.getCreatedAt());
        }
        return new BudgetResponse("This budget have not been associated","409");
    }
}
