package nl.colfield.bankappbe.api;

import nl.colfield.bankappbe.controller.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountEndpoint {

    @Autowired
    private AccountRepository accountRepository;




}


//    Acc toevoegen:
//        http://173.212.208.199:9000/acc/toevoegen/{IDKlant}
//        Geeft Json object mee met Acc eigenschappen ingevoerd in het formulier op de pagina.
