package nl.colfield.bankappbe.controller;


import nl.colfield.bankappbe.domain.Account;
import nl.colfield.bankappbe.domain.Customer;
import nl.colfield.bankappbe.helpers.AccountHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
            
            AccountHelper accountHelper = new AccountHelper();
            String IBAN;
            do{
            	IBAN = accountHelper.createIBAN();
            }while(!accountRepository.findByIBAN(IBAN).isEmpty());
            System.out.println(IBAN + " toegevoegd");
            account.setIBAN(IBAN);
            accountRepository.save(account);
        }
    }
    
    public void proberenInService() {//obsolite, word niet gebruikt
    	System.out.println("proberen");
    	
    	List<Account> accounts = accountRepository.findByIBAN("BLABLABLA");
    	System.out.println(accounts);
    }

    public Iterable <Account> getAll(){
        return accountRepository.findAll();
    }

    public void deleteAccount(long id) {
    	 Optional <Account> Optionalaccount= accountRepository.findById(id);
         if (Optionalaccount.isPresent()){
             Account account = Optionalaccount.get();
             accountRepository.delete(account);
         }
    }

    public Account findOne(long id){
        Optional <Account> account= accountRepository.findById(id);
            return account.get();
        }

    public void showAllBalance(){
        System.out.println(accountRepository.findByBalance(1000));
    }

    public List<Account> getAccountsOfCustomer(long id){
        return accountRepository.findByOwnerId(id);
    }
}
