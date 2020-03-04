package nl.colfield.bankappbe.api;

import nl.colfield.bankappbe.controller.CustomerService;
import nl.colfield.bankappbe.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerEndpoint {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("customer/add")
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

	@GetMapping("customer/displayall")
	public Iterable<Customer> getAllCustomers(){
		return customerService.getAllCustomers();

	}

	@GetMapping("customer/info/{id}")
	public  Customer findOneCustomer(@PathVariable long id){
		return customerService.findOne(id);
	}

}
