package nl.colfield.bankappbe.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private LocalDateTime dateCreated;
	private LocalDateTime dateSettled;
	private int amount;
	private boolean incoming;
	private String description;
	private String contraAccount;
	private String contraAccountName;
	private String via;
	
	@ManyToOne
	private Account account;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDateTime getDateSettled() {
		return dateSettled;
	}
	public void setDateSettled(LocalDateTime dateSettled) {
		this.dateSettled = dateSettled;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public boolean isIncoming() {
		return incoming;
	}
	public void setIncoming(boolean incoming) {
		this.incoming = incoming;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContraAccount() {
		return contraAccount;
	}
	public void setContraAccount(String contraAccount) {
		this.contraAccount = contraAccount;
	}
	public String getContraAccountName() {
		return contraAccountName;
	}
	public void setContraAccountName(String contraAccountName) {
		this.contraAccountName = contraAccountName;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}

	
	
}
