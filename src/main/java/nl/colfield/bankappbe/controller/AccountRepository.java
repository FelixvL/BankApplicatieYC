package nl.colfield.bankappbe.controller;

import nl.colfield.bankappbe.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AccountRepository extends CrudRepository<Account,Long> {

}
