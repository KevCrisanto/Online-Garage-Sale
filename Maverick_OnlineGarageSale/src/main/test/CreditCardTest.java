import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

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
		AddressDAO addressDAO = new AddressDAOImpl();
		String address1 = addressDAO.insertAddress(new Address("Turtley Ave.","","14A","","Arlington","TX","United States","76013"));
		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
		UserAccount mkay = userAccountDAO.getAccountByUsername("mkay");
		CreditCardDAO creditCardDAO = new CreditCardDAOImpl();
		String creditCard1 = creditCardDAO.insertCreditCard(new CreditCard("1111000022223333",mkay.getAccountId(),"Bub Sagott", expiry, "987", address1));
		System.out.println(creditCard1);
	}
}
