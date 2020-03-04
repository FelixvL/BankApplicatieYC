package nl.colfield.bankappbe.api;

import nl.colfield.bankappbe.controller.CustomerService;
import nl.colfield.bankappbe.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerEndpoint {
	
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
	@GetMapping("customer/newfake")
	public String newCustomerFake() {
		customerService.newCustomerFake();
		return "New customer added";
	}
	@PostMapping("customer/new")
	public String trailPost(@RequestBody Customer customer){
		System.out.println(customer.getFirstName());
		customerService.addNewCostumer(customer);
		return "gelukt";
	}

	@DeleteMapping("customer/delete/{id}")
	public String trailDelete(@PathVariable long id){
		customerService.deleteCostumer(id);

		return "Klant verwijderd";

	}

	@GetMapping("customer/displayAll")
	public Iterable<Customer> getAllCustomers(){
		return customerService.getAllCustomers();

	}

	@GetMapping("customer/Info/{id}")
	public  Customer findOneCustomer(@PathVariable long id){
		return customerService.findOne(id);
	}

}
