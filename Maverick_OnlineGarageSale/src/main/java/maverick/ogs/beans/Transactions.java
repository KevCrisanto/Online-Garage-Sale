package maverick.ogs.beans;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Transactions {
	
	@Id
	@Column
	private String transactionId;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	private UserAccount buyer;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	private UserAccount seller;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	private Item item;
	
	@Column
	private Float transactionAmount;
	
	@Column
	private String memo;
	
	public Transactions() {
		this.transactionId = UUID.randomUUID().toString();
	}
	
	public Transactions(String transactionId, UserAccount buyer, UserAccount seller, Item item, Float transactionAmount,
			String memo) {
		super();
		this.transactionId = transactionId;
		this.buyer = buyer;
		this.seller = seller;
		this.item = item;
		this.transactionAmount = transactionAmount;
		this.memo = memo;
	}

	public Transactions(UserAccount buyer, UserAccount seller, Item item, Float transactionAmount, String memo) {
		super();
		this.transactionId = UUID.randomUUID().toString();
		this.buyer = buyer;
		this.seller = seller;
		this.item = item;
		this.transactionAmount = transactionAmount;
		this.memo = memo;
	}

	public Transactions(UserAccount buyer, Item item, Float transactionAmount, String memo) {
		super();
		this.transactionId = UUID.randomUUID().toString();
		this.buyer = buyer;
		this.item = item;
		this.transactionAmount = transactionAmount;
		this.memo = memo;
	}
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public UserAccount getBuyer() {
		return buyer;
	}

	public void setBuyer(UserAccount buyer) {
		this.buyer = buyer;
	}

	public UserAccount getSeller() {
		return seller;
	}

	public void setSeller(UserAccount seller) {
		this.seller = seller;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
