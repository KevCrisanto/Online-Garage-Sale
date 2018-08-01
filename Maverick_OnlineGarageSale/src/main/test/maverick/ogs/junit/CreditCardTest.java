package maverick.ogs.junit;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
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
/*	@After
	public void tearDown() throws Exception{
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.createSQLQuery("TRUNCATE TABLE credit_card").executeUpdate();
			
			tx.commit();
		}
		catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
		}
		finally {
			session.close();
		}
	}*/
	
	@Test
	public void InsertCreditCardTest() {
		Date expiry = new Date();
		expiry.setMonth(Calendar.MARCH);
		expiry.setYear(2021);
		String date = "09 / 2011";
		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
		
		AddressDAO addressDAO = new AddressDAOImpl();
		String address1 = addressDAO.insertAddress(new Address("Turtley Ave.","","14A","","Arlington","TX","United States","76013"));
		List<Address> addresses = new ArrayList<Address>();
		List<UserAccount> users = new ArrayList<UserAccount>();
		
		UserAccount mkay = userAccountDAO.getAccountByUsername("mkay");
		String id3 = null;
		
		if (mkay == null) {
			id3 = userAccountDAO.insertAccount(new UserAccount("mkay", "password", "Mason", "Kay", "mkay@email.com", expiry, false, false, false, false));
			mkay = userAccountDAO.getAccountByUsername("mkay");
			users.add(mkay);
		} else {
			id3 = mkay.getAccountId();
			users.add(mkay);
		}
		
		Address address = addressDAO.getAddressById(address1);
		CreditCardDAO creditCardDAO = new CreditCardDAOImpl();
		
		String creditCard1 = creditCardDAO.insertCreditCard(new CreditCard("2111000022223833",users,"Bub Sagott", date, "987", address));
		

		creditCardDAO.deleteCreditCardById(creditCard1);
		userAccountDAO.deleteAccountById(id3);
		
		assertNotNull(creditCard1);
	}
	
	@Test
	public void getAllCardsTest() {
		AddressDAO addressDAO = new AddressDAOImpl();
		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
		CreditCardDAO creditCardDAO = new CreditCardDAOImpl();
		
		
	}
}
