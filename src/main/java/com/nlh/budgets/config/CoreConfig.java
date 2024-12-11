package com.nlh.budgets.config;

import com.nlh.budgets.repository.BudgetProjectRepository;
import com.nlh.budgets.repository.impl.BudgetProjectRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class CoreConfig {

    @Bean
    public BudgetProjectRepository budgetProjectRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        return new BudgetProjectRepositoryImpl(namedParameterJdbcTemplate);
    }
}
