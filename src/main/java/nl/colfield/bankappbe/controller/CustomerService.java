package nl.colfield.bankappbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.colfield.bankappbe.domain.Customer;


@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public Iterable<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	public void newCustomerFake() {
		Customer c = new Customer();
		c.setFirstName("Johan");
		c.setLastName("De Gooij");
		customerRepository.save(c);
	}
}
