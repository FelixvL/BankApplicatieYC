package nl.colfield.bankappbe.controller;

import nl.colfield.bankappbe.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountRepository extends CrudRepository<Account,Long> {

    List<Account> findByBalance (int balance);

    List<Account> findByOwnerId (long id);

}
