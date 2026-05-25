package com.realestate.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.app.entity.Property;
import com.realestate.app.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	 List<Transaction> findByTransactionTypeIgnoreCase(String transactionType);
}
