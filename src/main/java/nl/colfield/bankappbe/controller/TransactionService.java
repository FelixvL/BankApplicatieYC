package nl.colfield.bankappbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.colfield.bankappbe.domain.Account;
import nl.colfield.bankappbe.domain.Customer;
import nl.colfield.bankappbe.domain.Transaction;

@Service
@Transactional
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private AccountRepository accountRepository;

	public Iterable<Transaction> getAllTransactions(){
		return transactionRepository.findAll();
	}
	public void newTransaction(Transaction transaction, long id) {
		Account temp = accountRepository.findById(id).get();
		transaction.setAccount(temp);
		transactionRepository.save(transaction);
	}

}
