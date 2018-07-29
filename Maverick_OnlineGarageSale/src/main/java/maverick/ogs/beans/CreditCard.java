package maverick.ogs.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "CreditCard")
@Table(name = "credit_card")
public class CreditCard {
	
	@Id
	@Column(name = "card_number")
	private String cardNumber;
	
	@ManyToMany
	@JoinTable(
		        name = "credit_card_user_accounts", 
		        joinColumns = { @JoinColumn(name = "cardNumber") }, 
		        inverseJoinColumns = { @JoinColumn(name = "accountId") }
		      )
	private List<UserAccount> userAccounts;
	
	@Column(name = "card_name")
	private String cardName;

	@Column(name = "expiration")
	private Date expiration;
	
	@Column(name = "cvv")
	private String cvv;

	@ManyToOne(cascade=CascadeType.REMOVE)
	private Address address;
	
	public CreditCard(String cardNumber, List<UserAccount> userAccounts, String cardName, Date expiration, String cvv, Address address) {
		this.cardNumber = cardNumber;
		this.userAccounts = userAccounts;
		this.cardName = cardName;
		this.expiration = expiration;
		this.cvv = cvv;
		this.address = address;
	}
	
	public CreditCard(String cardNumber, String cardName, Date expiration, String cvv) {
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.expiration = expiration;
		this.cvv = cvv;
		this.userAccounts = null;
		this.address = null;
	}
	
	public CreditCard() {
		this.cardNumber = null;
		this.cardName = null;
		this.expiration = null;
		this.cvv = null;
		this.userAccounts = null;
		this.address = null;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public List<UserAccount> getUserAccounts() {
		return this.userAccounts;
	}

	public void setUserAccounts(List<UserAccount> userAccounts) {
		this.userAccounts = userAccounts;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
