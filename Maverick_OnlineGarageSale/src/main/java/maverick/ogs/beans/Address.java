package maverick.ogs.beans;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Address")
@Table(name = "address")
public class Address {
	
	@Id
	@Column(name = "address_id")
	private String addressId;
	
	@Column(name = "address_line_1")
	private String addressLine1;

	@Column(name = "address_line_2")
	private String addressLine2;

	@Column(name = "apt_number")
	private String aptNumber;

	@Column(name = "post_office_box")
	private String postOfficeBox;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "zipcode")
	private String zipcode;
	
	public Address() {
		this.addressId = UUID.randomUUID().toString();
	}
		
	public Address(String addressId, String addressLine1, String addressLine2, String aptNumber, String postOfficeBox,
			String city, String state, String country, String zipcode) {
		super();
		this.addressId = addressId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.aptNumber = aptNumber;
		this.postOfficeBox = postOfficeBox;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}
	
	public Address(String addressLine1, String addressLine2, String aptNumber, String postOfficeBox,
			String city, String state, String country, String zipcode) {
		super();
		this.addressId = UUID.randomUUID().toString();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.aptNumber = aptNumber;
		this.postOfficeBox = postOfficeBox;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAptNumber() {
		return this.aptNumber;
	}

	public void setAptNumber(String aptNumber) {
		this.aptNumber = aptNumber;
	}

	public String getPostOfficeBox() {
		return postOfficeBox;
	}

	public void setPostOfficeBox(String postOfficeBox) {
		this.postOfficeBox = postOfficeBox;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
