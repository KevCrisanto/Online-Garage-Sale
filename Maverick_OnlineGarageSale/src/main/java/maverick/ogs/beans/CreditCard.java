package maverick.ogs.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "CreditCard")
@Table(name = "credit_card")
public class CreditCard {
	
	@Id
	@Column(name = "credit_card_id")
	private String creditCardId;

	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "user_account")
	private UserAccount userAccount;
	
	@Column(name = "card_name")
	private String cardName;

	@Column(name = "expiration")
	private Date expiration;
	
	@Column(name = "cvv")
	private String cvv;
	
	@Column(name = "address")
	private Address address;
	
	public CreditCard(String cardNumber, UserAccount userAccount, String cardName, Date expiration, String cvv, Address address) {
		this.creditCardId = UUID.randomUUID().toString();
		this.cardNumber = cardNumber;
		this.userAccount = userAccount;
		this.cardName = cardName;
		this.expiration = expiration;
		this.cvv = cvv;
		this.address = address;
	}
	
	public CreditCard(String cardNumber, String cardName, Date expiration, String cvv) {
		this.creditCardId = UUID.randomUUID().toString();
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.expiration = expiration;
		this.cvv = cvv;
		this.userAccount = null;
		this.address = null;
	}
	
	public CreditCard() {
		this.creditCardId = UUID.randomUUID().toString();
		this.cardNumber = null;
		this.cardName = null;
		this.expiration = null;
		this.cvv = null;
		this.userAccount = null;
		this.address = null;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public UserAccount getUserAccounts() {
		return this.userAccount;
	}

	public void setUserAccounts(List<UserAccount> userAccounts) {
		this.userAccount = userAccount;
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
	
	public String getCreditCardId() {
		return this.creditCardId.toString();
	}
	
	public void setCreditCardId(String cardId) {
		this.creditCardId = cardId;
	}
}
