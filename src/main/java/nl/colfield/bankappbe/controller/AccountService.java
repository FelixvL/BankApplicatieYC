package nl.colfield.bankappbe.controller;


import nl.colfield.bankappbe.domain.Account;
import nl.colfield.bankappbe.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public void creatAccount(long id , Account account){
        Optional <Customer> Optionalcustomer= customerRepository.findById(id);
        if (Optionalcustomer.isPresent()){
            Customer customer = Optionalcustomer.get();
            account.setOwner(customer);
            accountRepository.save(account);
        }
    }

    public Iterable <Account> getAll(){
        return accountRepository.findAll();
    }



        /*find customer with id (see findOne methods)
        /create new account with that customer
        /save account (add to table)

        */

}
