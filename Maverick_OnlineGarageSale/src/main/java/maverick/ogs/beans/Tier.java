package maverick.ogs.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Tier")
@Table(name = "Tier")
public class Tier {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id", updatable = false, nullable = false)
	private String id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Integer user_id;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="subscriptions_and_tier_jc", 
				joinColumns=@JoinColumn(name="subscriptions_id"),
				inverseJoinColumns=@JoinColumn(name="tier_id"))
	private List<Subscriptions> subscriptions;
	
	public Tier (String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Tier (String name) {
		this.name = name;
	}
	
	public Tier() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public List<Subscriptions> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscriptions> subscriptions) {
		this.subscriptions = subscriptions;
	}
}
