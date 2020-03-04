package nl.colfield.bankappbe.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String IBAN;
	private enum AccountType{
		DEBITACCOUNT,
		SAVINGSACCOUNT,
		CREDITCARD		
	};
	private int balance; 
	private int maxlimit;
	private LocalDateTime dateOpened;   
	private boolean deleted;
	private double debitInterest;
	private double creditInterest;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getLimit() {
		return maxlimit;
	}
	public void setLimit(int limit) {
		this.maxlimit = limit;
	}
	public LocalDateTime getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(LocalDateTime dateOpened) {
		this.dateOpened = dateOpened;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
}
