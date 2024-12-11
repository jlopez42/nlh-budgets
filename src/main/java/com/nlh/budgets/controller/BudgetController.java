package com.nlh.budgets.controller;

import com.nlh.budgets.payloads.request.BudgetRequest;
import com.nlh.budgets.payloads.response.BudgetResponse;
import com.nlh.budgets.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/budget")
public class BudgetController {

    @Autowired
    private BudgetService service;

    public BudgetController(BudgetService service) {
        this.service = service;
    }

    @PostMapping("create")
    public ResponseEntity<BudgetResponse> createBudget(@RequestBody BudgetRequest budget){
        return ResponseEntity.ok(service.newBudget(budget));
    }
}
