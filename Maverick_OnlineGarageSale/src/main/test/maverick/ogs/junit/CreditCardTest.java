package maverick.ogs.junit;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import maverick.ogs.beans.Address;
import maverick.ogs.beans.CreditCard;
import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.AddressDAO;
import maverick.ogs.dao.AddressDAOImpl;
import maverick.ogs.dao.CreditCardDAO;
import maverick.ogs.dao.CreditCardDAOImpl;
import maverick.ogs.dao.UserAccountDAO;
import maverick.ogs.dao.UserAccountDAOImpl;
import maverick.ogs.util.HibernateUtil;

public class CreditCardTest {
	@Test
	public void InsertCreditCardTest() {
		Date expiry = new Date();
		expiry.setMonth(Calendar.MARCH);
		expiry.setYear(2021);
		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
		String id3 = userAccountDAO.insertAccount(new UserAccount("mkay", "password", "Mason", "Kay", "mkay@email.com", expiry, false, false, false, false));
		AddressDAO addressDAO = new AddressDAOImpl();
		String address1 = addressDAO.insertAddress(new Address("Turtley Ave.","","14A","","Arlington","TX","United States","76013"));
		List<Address> addresses = new ArrayList<Address>();
		List<UserAccount> users = new ArrayList<UserAccount>();
		UserAccount mkay = userAccountDAO.getAccountByUsername("mkay");
		Address address = addressDAO.getAddressById(address1);
		CreditCardDAO creditCardDAO = new CreditCardDAOImpl();
		users.add(mkay);
		String creditCard1 = creditCardDAO.insertCreditCard(new CreditCard("1111000022223333",mkay,"Bub Sagott", expiry, "987", address));
		System.out.println(creditCard1);
	}
}
