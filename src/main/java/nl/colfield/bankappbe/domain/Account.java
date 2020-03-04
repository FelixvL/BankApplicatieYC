package nl.colfield.bankappbe.domain;

import java.time.LocalDateTime;

import javax.persistence.*;

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


	@ManyToOne
	private Customer owner;
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
	public int getMaxLimit() {
		return maxlimit;
	}
	public void setMaxLimit(int limit) {
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

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}


	public double getDebitInterest() {
		return debitInterest;
	}

	public void setDebitInterest(double debitInterest) {
		this.debitInterest = debitInterest;
	}

	public double getCreditInterest() {
		return creditInterest;
	}

	public void setCreditInterest(double creditInterest) {
		this.creditInterest = creditInterest;
	}

	
	
}
