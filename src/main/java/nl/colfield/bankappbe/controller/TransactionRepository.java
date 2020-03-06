package nl.colfield.bankappbe.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.colfield.bankappbe.domain.Transaction;

import java.util.List;

@Component
public interface TransactionRepository extends CrudRepository<Transaction,Long>{

    List<Transaction> findByAccountId(long id);

}
