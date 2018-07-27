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
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Subscriptions")
@Table(name = "subscriptions")
public class Subscriptions
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name ="subscriptions_id", updatable = false, nullable = false)
	private Integer id;
	
	@Column(name = "user_id")
	private String userId;
	
	// Considering joining tier row's of paid subscription types and user roles to this table
	// Added Tier table for subscription tier types and roles. The Subscriptions table would record what
	// subscriptions and roles a user has from an @ManyToOne relationship
	// @ManyToOne
	//@Column
	@OneToMany (
			mappedBy = "subscriptions",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<Tier> tiers = new ArrayList<Tier>();
	
	@Column(name="subscription_end_date")
	private Date subscriptionEndDate;
	
	public Subscriptions(Integer id, String userId, List<Tier> tiers, Date subscriptionEndDate) {
		super();
		this.id = id;
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
