package nl.colfield.bankappbe.api;

import nl.colfield.bankappbe.controller.CustomerService;
import nl.colfield.bankappbe.controller.TransactionService;
import nl.colfield.bankappbe.domain.Customer;
import nl.colfield.bankappbe.domain.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionEndpoint {
	
	@Autowired
	private TransactionService transactionService;

	@PostMapping("transaction/add")
	public String addCustomer(@RequestBody Transaction transaction){
		transactionService.newTransaction(transaction);
		return "gelukt";
	}


	@GetMapping("transaction/displayall")
	public Iterable<Transaction> getAllCustomers(){
		return transactionService.getAllTransactions();

	}
}
