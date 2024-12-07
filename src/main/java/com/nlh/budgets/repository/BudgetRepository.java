package com.nlh.budgets.repository;

import com.nlh.budgets.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    Optional<Budget> findById(Long budgetId);

    Boolean existsByProjectId(Long projectId);
}
