package maverick.ogs.beans;

import java.util.ArrayList;
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
import javax.persistence.Table;

@Entity(name = "Tier")
@Table(name = "Tier")
public class Tier {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="tier_id", updatable = false, nullable = false)
	private Integer tier_id;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(mappedBy="tiers")
	private List<Subscriptions> subs = new ArrayList<Subscriptions>();

	
	public Tier (Integer tier_id, String name) {
		this.tier_id = tier_id;
		this.name = name;
	}
	
	public Tier (String name) {
		this.name = name;
	}
	
	public Tier() {
		super();
	}
	


	/**
	 * @return the tier_id
	 */
	public Integer getTier_id() {
		return tier_id;
	}

	/**
	 * @param tier_id the tier_id to set
	 */
	public void setTier_id(Integer tier_id) {
		this.tier_id = tier_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the subs
	 */
	public List<Subscriptions> getSubs() {
		return subs;
	}

	/**
	 * @param subs the subs to set
	 */
	public void setSubs(List<Subscriptions> subs) {
		this.subs = subs;
	}

//	public Subscriptions getU_id() {
//		return sub_tier;
//	}
//
//	public void setU_id(Subscriptions u_id) {
//		this.sub_tier = u_id;
//	}

//	public List<Subscriptions> getSubscriptions() {
//		return Subscriptions;
//	}
//
//	public void setSubscriptions(List<Subscriptions> Subscriptions) {
//		this.Subscriptions = Subscriptions;
//	}
}
