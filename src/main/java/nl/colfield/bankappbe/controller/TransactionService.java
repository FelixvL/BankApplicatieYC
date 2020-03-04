package nl.colfield.bankappbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.colfield.bankappbe.domain.Customer;
import nl.colfield.bankappbe.domain.Transaction;

@Service
@Transactional
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;

	public Iterable<Transaction> getAllTransactions(){
		return transactionRepository.findAll();
	}
	public void newTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}

}
