package com.nlh.budgets.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface BudgetProjectRepository {
    Boolean existsByProjectId(Long projectId);

}
