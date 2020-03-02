package nl.colfield.bankappbe.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.colfield.bankappbe.controller.CustomerService;
import nl.colfield.bankappbe.domain.Customer;

@RestController
public class TrialEndpoint {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("trial")
	public String returnString() {
		return "De BankApp is in de Lucht, met de tweede testcommit";
	}
	@GetMapping("emptycustomer")
	public Customer returnCustomer() {
		return new Customer();
	}
	@GetMapping("customer/all")
	public Iterable<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	@GetMapping("customer/newfake")
	public String newCustomerFake() {
		customerService.newCustomerFake();
		return "New customer added";
	}
}
