package nl.colfield.bankappbe.api;

import nl.colfield.bankappbe.controller.AccountRepository;
import nl.colfield.bankappbe.controller.AccountService;
import nl.colfield.bankappbe.controller.CustomerService;
import nl.colfield.bankappbe.domain.Account;
import nl.colfield.bankappbe.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountEndpoint {

    @Autowired
    private AccountService accountService;

    @PostMapping("acc/toevoegen/{id}")
    public void addAccount(@PathVariable long id, @RequestBody Account account){
        accountService.creatAccount(id, account);
    }

	@DeleteMapping("acc/delete/{id}")
	public String deleteAccount(@PathVariable long id){
		accountService.deleteAccount(id);
		return "Account verwijderd";


    }

    @GetMapping("show/account")
    public Iterable <Account> showAllAccounts(){

        return accountService.getAll();
    }


    @GetMapping("acc/info/{id}")
    public Account showOneAccount(@PathVariable long id){
        return accountService.findOne(id);

    }
}
