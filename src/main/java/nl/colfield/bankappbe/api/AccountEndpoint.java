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

    @GetMapping("show/account")
    public Iterable <Account> showAllAccounts(){
        return accountService.getAll();
    }






}
//    Acc toevoegen:
//        http://173.212.208.199:9000/acc/toevoegen/{IDKlant}
//        Geeft Json object mee met Acc eigenschappen ingevoerd in het formulier op de pagina.
