package com.realestate.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.realestate.app.dto.TransactionDto;
import com.realestate.app.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // GET ALL
    @GetMapping("/")
    public ResponseEntity<List<TransactionDto>> getAllTransactionDetails() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    // GET BY TYPE
    @GetMapping("/type/{transactionType}")
    public ResponseEntity<List<TransactionDto>> getTransactionsByType(
            @PathVariable String transactionType) {
        return ResponseEntity.ok(
                transactionService.getTransactionsByType(transactionType)
        );
    }
}