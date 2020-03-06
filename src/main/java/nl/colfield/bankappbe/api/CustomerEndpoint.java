package nl.colfield.bankappbe.api;

import nl.colfield.bankappbe.controller.CustomerService;
import nl.colfield.bankappbe.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerEndpoint {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("add/customer")
	public String addCustomer(@RequestBody Customer customer){
		System.out.println(customer.getFirstName());
		customerService.addNewCostumer(customer);
		return "gelukt";
	}

	@DeleteMapping("delete/customerid/{id}")
	public String deleteCustomer(@PathVariable long id){
		return customerService.deleteCostumer(id);

	}

	@GetMapping("display/all/customers")
	public Iterable<Customer> getAllCustomers(){
		return customerService.getAllCustomers();

	}

	@GetMapping("info/customerid/{id}")
	public  Customer findOneCustomer(@PathVariable long id){
		return customerService.findOne(id);
	}


	@GetMapping("search/customer/{name}")
	public List<Customer> searchName(@PathVariable String name){
		return customerService.findByName(name);


	}

}
