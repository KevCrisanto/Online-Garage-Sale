package maverick.ogs.beans;

import java.util.Date;
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
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private String accountId;
	
	@Column(name = "card_name")
	private String cardName;

	@Column(name = "expiration")
	private Date expiration;
	
	@Column(name = "cvv")
	private String cvv;
	
	@ManyToOne
	@JoinColumn(name = "address_id")
	private String addressId;
	
	public CreditCard(String cardNumber, String accountId, String cardName, Date expiration, String cvv, String addressId) {
		this.creditCardId = UUID.randomUUID().toString();
		this.cardNumber = cardNumber;
		this.accountId = accountId;
		this.cardName = cardName;
		this.expiration = expiration;
		this.cvv = cvv;
		this.addressId = addressId;
	}
	
	public CreditCard(String cardNumber, String cardName, Date expiration, String cvv) {
		this.creditCardId = UUID.randomUUID().toString();
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.expiration = expiration;
		this.cvv = cvv;
		this.accountId = null;
		this.addressId = null;
	}
	
	public CreditCard() {
		this.creditCardId = UUID.randomUUID().toString();
		this.cardNumber = null;
		this.cardName = null;
		this.expiration = null;
		this.cvv = null;
		this.accountId = null;
		this.addressId = null;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
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

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	
	public String getCreditCardId() {
		return this.creditCardId.toString();
	}
	
	public void setCreditCardId(String cardId) {
		this.creditCardId = cardId;
	}
}
