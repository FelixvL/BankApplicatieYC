package nl.colfield.bankappbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.colfield.bankappbe.domain.Account;
import nl.colfield.bankappbe.domain.Customer;
import nl.colfield.bankappbe.domain.Transaction;

import java.util.List;

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

	public String newTransaction(Transaction transaction, long id) {
		Account temp = accountRepository.findById(id).get();
		transaction.setAccount(temp);

		if (transaction.isIncoming()) {
			int newBalance = temp.getBalance() + transaction.getAmount();
			transactionRepository.save(transaction);
			temp.setBalance(newBalance);
			return "Er is " + transaction.getAmount() + "euro bijgeschreven";
		}
		else {
			int newBalance = temp.getBalance() - transaction.getAmount();
			if (newBalance > 0) {
				transactionRepository.save(transaction);
				temp.setBalance(newBalance);
				return "Er is " + transaction.getAmount() + "euro afgescreven";
			}
			return "Je hebt niet genoeg geld voor deze transactie.";
		}
	}

	public List <Transaction> getTransactions(long id){
		return transactionRepository.findByAccountId(id);

	}

}
