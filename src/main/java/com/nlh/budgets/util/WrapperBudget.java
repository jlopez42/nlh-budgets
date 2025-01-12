package com.nlh.budgets.util;

import com.nlh.budgets.model.Budget;
import com.nlh.budgets.payloads.response.Budgets;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class WrapperBudget {
    public static List<Budgets> convertTo (List<Budget> projectList){
        List<Budgets> budgets = new ArrayList<>();
        projectList.forEach(budget ->{
            if(Objects.nonNull(budget.getCreatedAt())) {
                budgets.add(new Budgets(budget.getId(), budget.getProjectId(), Date.from(budget.getCreatedAt().toInstant())));
            }
        });
        return budgets;
    }

    public static LocalDate dateFrom (Date date){
        Instant instant = date.toInstant();
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Budget budgetFrom(Budget budget) {
        Budget model = new Budget();
        model.setId(budget.getId());
        model.setProjectId(budget.getProjectId());
        model.setDocumentId(budget.getDocumentId());
        return model;
    }

    public static Budget budgetUpdateFrom(Budget budget, Budget budgetUpgrade) {
        budget.setId(budgetUpgrade.getId());
        budget.setProjectId(budgetUpgrade.getProjectId());
        budget.setDocumentId(budgetUpgrade.getDocumentId());
        budget.setUpdatedAt(budgetUpgrade.getUpdatedAt());
        return budget;
    }
}
