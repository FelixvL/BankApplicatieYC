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

    @PostMapping("add/account/to/customerid/{id}")
    public String addAccount(@PathVariable long id, @RequestBody Account account){
        accountService.creatAccount(id, account);
        return  "Account toegevoegd aan Klant";
    }

	@DeleteMapping("delete/accountid/{id}")
	public String deleteAccount(@PathVariable long id){
		accountService.deleteAccount(id);
		return "Account verwijderd van Klant " + id;

    }

    @GetMapping("display/all/accounts")
    public Iterable <Account> showAllAccounts(){

        return accountService.getAll();
    }


    @GetMapping("info/accountid/{id}")
    public Account showOneAccount(@PathVariable long id){
        return accountService.findOne(id);

    }

    @GetMapping("display/all/accounts/of/customerid/{id}")
    public List <Account> accDisplayAllCustomerId(@PathVariable long id){
        return accountService.getAccountsOfCustomer(id);
    }
    
    @GetMapping("proberen")//this endpoint is for testing, obsolite , can be removed
    public String llll(){
    	//accountService.proberenInService();
    	accountService.creatAccount(1 , new Account());
    	return "het werkt";
    }
}
