package com.nlh.budgets.payloads.request;

import com.nlh.budgets.model.Budget;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BudgetRequest {
    private Budget budget;
}
