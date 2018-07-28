package maverick.ogs.beans;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Item {
	
	@Id
	@Column(name = "item_id")
	private String itemId;
	
	@ManyToOne
	private UserAccount accountId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "item_status")
	private String itemStatus;
	
	@Column(name = "price")
	private Float price;
	
	@Column(name = "category")
	private String category;
	
	public Item() {
		this.itemId = UUID.randomUUID().toString();
	}
	
	public Item(UserAccount accountId, String description, String itemStatus, Float price,
			String category) {
		super();
		this.itemId = UUID.randomUUID().toString();
		this.accountId = accountId;
		this.description = description;
		this.itemStatus = itemStatus;
		this.price = price;
		this.category = category;
	}
	
	public Item(String itemId, UserAccount accountId, String description, String itemStatus, Float price,
			String category) {
		super();
		this.itemId = itemId;
		this.accountId = accountId;
		this.description = description;
		this.itemStatus = itemStatus;
		this.price = price;
		this.category = category;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	public UserAccount getAccountId() {
		return accountId;
	}

	public void setAccountId(UserAccount accountId) {
		this.accountId = accountId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
