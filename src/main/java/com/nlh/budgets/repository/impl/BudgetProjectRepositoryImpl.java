package com.nlh.budgets.repository.impl;

import com.nlh.budgets.repository.BudgetProjectRepository;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Map;

public class BudgetProjectRepositoryImpl implements BudgetProjectRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbc;

    public BudgetProjectRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbc) {
        this.namedParameterJdbc = namedParameterJdbc;
    }


    @Override
    public Boolean existsByProjectId(Long projectId) {
        var params = Map.of("project_id", projectId);

        return this.namedParameterJdbc.query("""
                                select count(*) as project
                                from projects
                                where id = :project_id;
                        """,
                params,
                getProjectExtract()
        );
    }

    private ResultSetExtractor<Boolean> getProjectExtract() {
        return rs -> {
            if (rs.next()){
                return rs.getInt("project") > 0 ? true:false;
            }
            return false;
        };
    }
}
