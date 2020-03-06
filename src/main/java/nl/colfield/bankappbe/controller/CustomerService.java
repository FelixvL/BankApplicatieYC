package nl.colfield.bankappbe.controller;

import nl.colfield.bankappbe.domain.Account;
import nl.colfield.bankappbe.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;
	
	public Iterable<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}

	public void addNewCostumer(Customer customer){
		customerRepository.save(customer);
	}

	public Customer findOne(Long id){
		Optional<Customer> customer = customerRepository.findById(id);
			return customer.get();
		}

	public  String deleteCostumer(Long id) {
        Customer customer = findOne(id);
        if (customer == null) {
            return "klant niet gevonden";
        }
        else if(accountRepository.findByOwnerId(id).isEmpty()){
			customerRepository.delete(customer);
			return customer.getFirstName() +" "+ customer.getLastName() + " is verwijderd!";

		}

        else { return "klant heeft nog accounts! Verwijder deze eerst!";
        }

    }

		public List <Customer> findByName(String name){
			List <Customer> firstName = customerRepository.findByFirstNameLike(name);
			List <Customer> lastName = customerRepository.findByLastNameLike(name);
			firstName.addAll(lastName);
			return firstName;
        }


}
