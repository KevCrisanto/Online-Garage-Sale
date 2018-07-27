package maverick.ogs.beans;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "UserAccount")
@Table(name = "user_account")
public class UserAccount {
	
	@Id
	@Column(name="account_id", unique=true)
	private String accountId;
	
	@Column(name="username", unique=true)
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="is_verified")
	private boolean isVerified;
	
	@Column(name="is_premium")
	private boolean isPremium;
	
	@Column(name="is_admin")
	private boolean isAdmin;
	
	@Column(name="is_active")
	private boolean isActive;

	public UserAccount(String accountId, String username, String password, String firstName, String lastName, String email,
			Date creationDate, boolean isVerified, boolean isPremium, boolean isAdmin, boolean isActive) {
		super();
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creationDate = creationDate;
		this.isVerified = isVerified;
		this.isPremium = isPremium;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
	}

	public UserAccount(String username, String password, String firstName, String lastName, String email,
			Date creationDate, boolean isVerified, boolean isPremium, boolean isAdmin, boolean isActive) {
		super();
		this.accountId = UUID.randomUUID().toString();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creationDate = creationDate;
		this.isVerified = isVerified;
		this.isPremium = isPremium;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
	}
	
	public UserAccount(String username, String password, String firstName, String lastName, String email,
			Date creationDate) {
		super();
		this.accountId = UUID.randomUUID().toString();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creationDate = creationDate;
		this.isVerified = false;
		this.isPremium = false;
		this.isAdmin = false;
		this.isActive = false;
	}
	
	public UserAccount(String username, String password, String firstName, String lastName, String email) {
		super();
		this.accountId = UUID.randomUUID().toString();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creationDate = new Date();
		this.isVerified = false;
		this.isPremium = false;
		this.isAdmin = false;
		this.isActive = false;
	}
	
	public UserAccount() {
		super();
		this.accountId = UUID.randomUUID().toString();
	}

	public String getAccountId() {
		return this.accountId;
	}

	public void setUserId(String accountId) {
		this.accountId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
