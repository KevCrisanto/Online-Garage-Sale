package maverick.ogs.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Tier {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id", updatable = false, nullable = false)
	private String id;
	
	@Column
	private String name;
	
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

	
}
