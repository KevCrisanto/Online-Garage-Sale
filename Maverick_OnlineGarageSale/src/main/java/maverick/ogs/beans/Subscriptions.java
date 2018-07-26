package maverick.ogs.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Subscriptions
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name ="id", updatable = false, nullable = false)
	private Integer id;
	
	@Column(name = "user_id")
	private String userId;
	
	// Considering joining tier row's of paid subscription types and user roles to this table
	//@ManyToMany
	@Column
	private String tier;
	
	@Column
	private Date subscriptionEndDate;
	
	public Subscriptions(Integer id, String userId, String tier, Date subscriptionEndDate) {
		super();
		id = id;
		this.userId = userId;
		this.tier = tier;
		this.subscriptionEndDate = subscriptionEndDate;
	}
	
	public Subscriptions(String userId, String tier, Date subscriptionEndDate) {
		super();
		this.userId = userId;
		this.tier = tier;
		this.subscriptionEndDate = subscriptionEndDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public Date getSubscriptionEndDate() {
		return subscriptionEndDate;
	}
	public void setSubscriptionEndDate(Date subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}
	
}
