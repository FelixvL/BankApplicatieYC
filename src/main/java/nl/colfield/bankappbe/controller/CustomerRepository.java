package nl.colfield.bankappbe.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.colfield.bankappbe.domain.Customer;

@Component
public interface CustomerRepository extends CrudRepository<Customer,Long>{

}
