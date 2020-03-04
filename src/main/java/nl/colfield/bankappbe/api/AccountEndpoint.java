package nl.colfield.bankappbe.api;

import nl.colfield.bankappbe.controller.AccountRepository;
import nl.colfield.bankappbe.controller.AccountService;
import nl.colfield.bankappbe.controller.CustomerService;
import nl.colfield.bankappbe.domain.Account;
import nl.colfield.bankappbe.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountEndpoint {

    @Autowired
    private AccountService accountService;

    @PostMapping("acc/toevoegen/{id}") // TODO verander naar add/account/to/customerid/{id}
    public void addAccount(@PathVariable long id, @RequestBody Account account){
        accountService.creatAccount(id, account);
    }

	@DeleteMapping("acc/delete/{id}") //TODO verander naar delete/accountid/{id}
	public String deleteAccount(@PathVariable long id){
		accountService.deleteAccount(id);
		return "Account verwijderd";


    }

    @GetMapping("show/account") //TODO veranderen naar display/all/accounts
    public Iterable <Account> showAllAccounts(){

        return accountService.getAll();
    }


    @GetMapping("acc/info/{id}") //TODO veranderen naar info/accountid/{id}
    public Account showOneAccount(@PathVariable long id){
        return accountService.findOne(id);

    }

    @GetMapping("acc/displayall/{Id}") //TODO veranderen naar display/all/accounts/of/customerid/{id}
    public List <Account> accDisplayAllCustomerId(@PathVariable long Id){
        return accountService.getAccountsOfCustomer(Id);
    }
}
