package com.realestate.app.service;

import java.util.List;
import com.realestate.app.dto.TransactionDto;

public interface TransactionService {

    List<TransactionDto> getAllTransactions();

    TransactionDto getTransactionById(Long transactionId);

    List<TransactionDto> getTransactionsByType(String transactionType);
}