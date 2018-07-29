package maverick.ogs.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Subscriptions")
@Table(name = "Subscriptions")
public class Subscriptions
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name ="sub_id", updatable = false, nullable = false)
	private Integer sub_id;
	
	@Column(name = "user_id")
	private String userId;
	
	// Considering joining tier row's of paid subscription types and user roles to this table
	// Added Tier table for subscription tier types and roles. The Subscriptions table would record what
	// subscriptions and roles a user has from an @ManyToOne relationship
	// @ManyToOne
	//@Column

	@ManyToMany
	@JoinTable(
	        name = "Tier_Subscriptions", 
	        joinColumns = { @JoinColumn(name = "sub_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "tier_id") }
	    )
    private List<Tier> tiers = new ArrayList<Tier>();
	
	@Column(name="subscription_end_date")
	private Date subscriptionEndDate;
	
	public Subscriptions(Integer sub_id, String userId, List<Tier> tiers, Date subscriptionEndDate) {
		super();
		this.sub_id = sub_id;
		this.userId = userId;
		this.tiers = tiers;
		this.subscriptionEndDate = subscriptionEndDate;
	}
	
	public Subscriptions(String userId, List<Tier> tiers, Date subscriptionEndDate) {
		super();
		this.userId = userId;
		this.tiers = tiers;
		this.subscriptionEndDate = subscriptionEndDate;
	}
	public Subscriptions() {
		super();
	}
	
	
	/**
	 * @return the sub_id
	 */
	public Integer getSub_id() {
		return sub_id;
	}

	/**
	 * @param sub_id the sub_id to set
	 */
	public void setSub_id(Integer sub_id) {
		this.sub_id = sub_id;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<Tier> getTiers() {
		return tiers;
	}
	public void setTiers(List<Tier> tiers) {
		this.tiers = tiers;
	}
	public Date getSubscriptionEndDate() {
		return subscriptionEndDate;
	}
	public void setSubscriptionEndDate(Date subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}
	
}
