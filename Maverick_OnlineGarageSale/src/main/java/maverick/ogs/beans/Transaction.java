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
public class Transaction {
	
	@Id
	@Column
	private String transactionId;
	
	@Column
	@OneToOne(cascade=CascadeType.REMOVE)
	private String buyerId;
	
	@Column
	@OneToOne(cascade=CascadeType.REMOVE)
	private String sellerId;
	
	@Column
	@OneToOne(cascade=CascadeType.REMOVE)
	private String itemId;
	
	@Column
	private Float transactionAmount;
	
	@Column
	private String memo;
	
	public Transaction() {
		this.transactionId = UUID.randomUUID().toString();
	}
	
	public Transaction(String transactionId, String buyerId, String sellerId, String itemId, Float transactionAmount,
			String memo) {
		super();
		this.transactionId = transactionId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.itemId = itemId;
		this.transactionAmount = transactionAmount;
		this.memo = memo;
	}

	public Transaction(String buyerId, String sellerId, String itemId, Float transactionAmount, String memo) {
		super();
		this.transactionId = UUID.randomUUID().toString();
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.itemId = itemId;
		this.transactionAmount = transactionAmount;
		this.memo = memo;
	}

	public Transaction(String buyerId, String itemId, Float transactionAmount, String memo) {
		super();
		this.transactionId = UUID.randomUUID().toString();
		this.buyerId = buyerId;
		this.itemId = itemId;
		this.transactionAmount = transactionAmount;
		this.memo = memo;
	}
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
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
