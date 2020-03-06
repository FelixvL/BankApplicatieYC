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

	@PostMapping("do/transaction/accountid/{id}")
	public String addCustomer(@RequestBody Transaction transaction, @PathVariable long id){
		System.out.println("dotransaction");
		transactionService.newTransaction(transaction, id);
		return "gelukt";
	}


	@GetMapping("display/all/transactions")
	public Iterable<Transaction> getAllCustomers(){
		return transactionService.getAllTransactions();

	}
}
