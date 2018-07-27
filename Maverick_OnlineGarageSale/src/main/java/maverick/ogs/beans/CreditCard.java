package maverick.ogs.beans;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "CreditCard")
@Table(name ="credit_card")
public class CreditCard {
	
	@Id
	@Column(name = "credit_card_id")
	private String creditCardId;
	
	@Id
	@Column(name = "card_number")
	private Integer cardNumber;
	
	@OneToOne
	@JoinColumn(name = "account_id")
	private String accountId;
	
	@Id
	@Column(name = "card_name")
	private String cardName;

	@Id
	@Column(name = "expiration")
	private Date expiration;
	
	@Id
	@Column(name = "cvv")
	private Integer cvv;
	
	@ManyToOne
	@JoinColumn(name = "address_id")
	private String addressId;
	
	public CreditCard(Integer cardNumber, String accountId, String cardName, Date expiration, Integer cvv, String addressId) {
		this.creditCardId = UUID.randomUUID().toString();
		this.cardNumber = cardNumber;
		this.accountId = accountId;
		this.cardName = cardName;
		this.expiration = expiration;
		this.cvv = cvv;
		this.addressId = addressId;
	}
	
	public CreditCard(Integer cardNumber, String cardName, Date expiration, Integer cvv) {
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

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
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

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
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
