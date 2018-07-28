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
	private Integer id;
	
	@Column(name="name")
	private String name;
//	
//	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Subscriptions.class)
//	@JoinColumn(name = "user_id")
//	private Integer user_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_tier")
	private Subscriptions sub_tier;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="subscriptions_and_tier_jc", 
				joinColumns=@JoinColumn(name="subscriptions_id"),
				inverseJoinColumns=@JoinColumn(name="tier_id"))
	private List<Subscriptions> Subscriptions;
	
	public Tier (Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Tier (String name) {
		this.name = name;
	}
	
	public Tier() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subscriptions getU_id() {
		return sub_tier;
	}

	public void setU_id(Subscriptions u_id) {
		this.sub_tier = u_id;
	}

	public List<Subscriptions> getSubscriptions() {
		return Subscriptions;
	}

	public void setSubscriptions(List<Subscriptions> Subscriptions) {
		this.Subscriptions = Subscriptions;
	}
}
