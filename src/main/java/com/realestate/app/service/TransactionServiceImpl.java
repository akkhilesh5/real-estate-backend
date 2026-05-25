package com.realestate.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.app.dto.TransactionDto;
import com.realestate.app.entity.Transaction;
import com.realestate.app.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TransactionDto> getAllTransactions() {
        return convertToDtoList(transactionRepository.findAll());
    }

    @Override
    public TransactionDto getTransactionById(Long transactionId) {

        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        return convertToDto(transaction);
    }

    @Override
    public List<TransactionDto> getTransactionsByType(String transactionType) {
        return convertToDtoList(
                transactionRepository.findByTransactionTypeIgnoreCase(transactionType)
        );
    }

    private TransactionDto convertToDto(Transaction transaction) {
        return modelMapper.map(transaction, TransactionDto.class);
    }

    private List<TransactionDto> convertToDtoList(List<Transaction> transactionList) {
        return transactionList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private Transaction convertToDao(TransactionDto transactionDto) {
        return modelMapper.map(transactionDto, Transaction.class);
    }
}