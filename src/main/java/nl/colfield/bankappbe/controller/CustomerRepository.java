package nl.colfield.bankappbe.controller;

import nl.colfield.bankappbe.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.colfield.bankappbe.domain.Customer;

import java.util.List;

@Component
public interface CustomerRepository extends CrudRepository<Customer,Long>{

    List<Customer> findByFirstNameLike (String name);

    List<Customer> findByLastNameLike (String name);

}

