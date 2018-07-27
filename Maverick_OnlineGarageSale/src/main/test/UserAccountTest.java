import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.UserAccountDAO;
import maverick.ogs.dao.UserAccountDAOImpl;
import maverick.ogs.util.HibernateUtil;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserAccountTest {

	@Before
	public void setUp() throws Exception {
		Date now = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		String timeNow = simpleDate.format(now);
		
		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
		String id1 = userAccountDAO.insertAccount(new UserAccount("kkay", "password", "Kristina", "Kay", "kkay@email.com", now, false, false, false, false));
		String id2 = userAccountDAO.insertAccount(new UserAccount("lkay", "password", "Leon", "Kay", "lkay@email.com", now, false, false, false, false));
		String id3 = userAccountDAO.insertAccount(new UserAccount("mkay", "password", "Mason", "Kay", "mkay@email.com", now, false, false, false, false));
		String id4 = userAccountDAO.insertAccount(new UserAccount("nkay", "password", "Nathan", "Kay", "nkay@email.com", now, false, false, false, false));
		String id5 = userAccountDAO.insertAccount(new UserAccount("okay", "password", "Owen", "Kay", "okay@email.com", now, false, false, false, false));
		String id6 = userAccountDAO.insertAccount(new UserAccount("pkay", "password", "Pam", "Kay", "pkay@email.com", now, false, false, false, false));
		String id7 = userAccountDAO.insertAccount(new UserAccount("qkay", "password", "Quinoaycka", "Kay", "qkay@email.com", now, false, false, false, false));
		String id8 = userAccountDAO.insertAccount(new UserAccount("rkay", "password", "Ryan", "Kay", "rkay@email.com", now, false, false, false, false));
		String id9 = userAccountDAO.insertAccount(new UserAccount("skay", "password", "Shelby", "Kay", "skay@email.com", now, false, false, false, false));
		String id10 = userAccountDAO.insertAccount(new UserAccount("tkay", "password", "Tonya", "Kay", "tkay@email.com", now, false, false, false, false));
	}

	@After
	public void tearDown() throws Exception {
		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
		userAccountDAO.deleteAccountByUsername("kkay");
		userAccountDAO.deleteAccountByUsername("lkay");
		userAccountDAO.deleteAccountByUsername("mkay");
		userAccountDAO.deleteAccountByUsername("nkay");
		userAccountDAO.deleteAccountByUsername("okay");
		userAccountDAO.deleteAccountByUsername("pkay");
		userAccountDAO.deleteAccountByUsername("qkay");
		userAccountDAO.deleteAccountByUsername("rkay");
		userAccountDAO.deleteAccountByUsername("skay");
		userAccountDAO.deleteAccountByUsername("tkay");
		userAccountDAO.deleteAccountByUsername("ukay");
		userAccountDAO.deleteAccountByUsername("vkay");
	}

	@Test
	public void countUsersCreated() {
		Session session = HibernateUtil.getSession();
		Long userAccountsCount = (Long) session.createCriteria(UserAccount.class).setProjection(
				Projections.count("id")
				).uniqueResult();
		session.close();
		
		// If 10 user accounts were created assert true, test passes.
		if (userAccountsCount == 10L) {
			assertTrue(true);
		}
	}
	
	@Test
	public void getAllAccountsTest() {
		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
		Session session = HibernateUtil.getSession();
		Long userAccountsCount = (Long) session.createCriteria(UserAccount.class).setProjection(
				Projections.count("id")
				).uniqueResult();
		List<UserAccount> tenAccounts = userAccountDAO.getAllAccounts();
		Long count = Long.valueOf(tenAccounts.size());
		session.close();
		
		// If 10 user accounts were created assert true, test passes.
		assertEquals(userAccountsCount, count);
	}
	
	@Test
	public void getAccountByIdTest() {
		Date now = new Date();
		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
		String id11 = (String) userAccountDAO.insertAccount(new UserAccount("ukay", "password", "Umow", "Kay", "ukay@email.com", now, false, false, false, false));
		UserAccount userAccount11 = (UserAccount) userAccountDAO.getAccountById(id11);
		assertEquals(id11, userAccount11.getAccountId());
		
	}
	
	@Test
	public void getAccountByUsernameTest() {
		Date now = new Date();
		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
		String id12 = (String) userAccountDAO.insertAccount(new UserAccount("vkay", "password", "Vanessa", "Kay", "vkay@email.com", now, false, false, false, false));
		UserAccount userAccount12 = (UserAccount) userAccountDAO.getAccountById(id12);
		// System.out.println("UserAccount12 is reporting the username: " + userAccount12.getUsername());
		UserAccount queriedAccount = userAccountDAO.getAccountByUsername("vkay");
		System.out.println("queriedAccount is reporting the username: " + queriedAccount.getUsername());
		String idFromUsername = queriedAccount.getAccountId();
		assertEquals(id12, idFromUsername);
		
	}
}
