package com.nlh.budgets.payloads.request;

import com.nlh.budgets.model.Budget;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BudgetRequest {
    private Budget budget;
}
