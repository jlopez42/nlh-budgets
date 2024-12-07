package com.nlh.budgets.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@Entity(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue
    private Long id;
    private Long projectId;
    private Float amount;
    private Date createdAt;
    private Date updatedAt;
}
