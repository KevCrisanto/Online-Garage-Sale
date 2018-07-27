import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import maverick.ogs.beans.Subscriptions;
import maverick.ogs.beans.Tier;
import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.SubscriptionsDAO;
import maverick.ogs.dao.SubscriptionsDAOImpl;
import maverick.ogs.dao.TierDAO;
import maverick.ogs.dao.TierDAOImpl;
import maverick.ogs.dao.UserAccountDAO;
import maverick.ogs.dao.UserAccountDAOImpl;

public class TiersAndSubscriptionsTest {

	@Before
	public void setUp() throws Exception {
		Date now = new Date();
		
		TierDAO tierDAO = new TierDAOImpl();
		SubscriptionsDAO subscriptionsDAO = new SubscriptionsDAOImpl();
		
		Integer tier1 = tierDAO.addTier(new Tier("Unverified"));
		Integer tier2 = tierDAO.addTier(new Tier("Verified"));
		Integer tier3 = tierDAO.addTier(new Tier("Premium"));
		Integer tier4 = tierDAO.addTier(new Tier("Admin"));
		
		Tier unverified = tierDAO.getTierById(tier1);
		Tier verified = tierDAO.getTierById(tier2);
		Tier premium = tierDAO.getTierById(tier3);
		Tier admin = tierDAO.getTierById(tier4);
		
		List<Tier> unverifiedNotAdmin = new ArrayList<Tier>();
		List<Tier> verifiedNotAdmin = new ArrayList<Tier>(tier2);
		List<Tier> verifiedAdmin = new ArrayList<Tier>();
		List<Tier> unverifiedAdmin = new ArrayList<Tier>();
		
		unverifiedNotAdmin.add(unverified);
		
		verifiedNotAdmin.add(verified);
		
		verifiedAdmin.add(verified);
		verifiedAdmin.add(admin);
		
		unverifiedAdmin.add(unverified);
		unverifiedAdmin.add(admin);
		
		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
		String id1 = userAccountDAO.insertAccount(new UserAccount("kkay", "password", "Kristina", "Kay", "kkay@email.com", now, true, false, true, false));
		String id2 = userAccountDAO.insertAccount(new UserAccount("lkay", "password", "Leon", "Kay", "lkay@email.com", now, false, false, true, false));
		String id3 = userAccountDAO.insertAccount(new UserAccount("mkay", "password", "Mason", "Kay", "mkay@email.com", now, true, false, true, false));
		String id4 = userAccountDAO.insertAccount(new UserAccount("nkay", "password", "Nathan", "Kay", "nkay@email.com", now, false, false, true, false));
		String id5 = userAccountDAO.insertAccount(new UserAccount("okay", "password", "Owen", "Kay", "okay@email.com", now, true, false, true, false));
		String id6 = userAccountDAO.insertAccount(new UserAccount("pkay", "password", "Pam", "Kay", "pkay@email.com", now, false, false, false, false));
		String id7 = userAccountDAO.insertAccount(new UserAccount("qkay", "password", "Quinoaycka", "Kay", "qkay@email.com", now, true, false, false, false));
		String id8 = userAccountDAO.insertAccount(new UserAccount("rkay", "password", "Ryan", "Kay", "rkay@email.com", now, false, false, false, false));
		String id9 = userAccountDAO.insertAccount(new UserAccount("skay", "password", "Shelby", "Kay", "skay@email.com", now, true, false, false, false));
		String id10 = userAccountDAO.insertAccount(new UserAccount("tkay", "password", "Tonya", "Kay", "tkay@email.com", now, false, false, false, false));
		
		Integer subscriptions1 = subscriptionsDAO.addSubscriptions(new Subscriptions(id1, verifiedAdmin, now));
		Integer subscriptions2 = subscriptionsDAO.addSubscriptions(new Subscriptions(id2, unverifiedAdmin, now));
		Integer subscriptions3 = subscriptionsDAO.addSubscriptions(new Subscriptions(id3, verifiedAdmin, now));
		Integer subscriptions4 = subscriptionsDAO.addSubscriptions(new Subscriptions(id4, unverifiedAdmin, now));
		Integer subscriptions5 = subscriptionsDAO.addSubscriptions(new Subscriptions(id5, verifiedAdmin, now));
		Integer subscriptions6 = subscriptionsDAO.addSubscriptions(new Subscriptions(id6, unverifiedNotAdmin, now));
		Integer subscriptions7 = subscriptionsDAO.addSubscriptions(new Subscriptions(id7, verifiedNotAdmin, now));
		Integer subscriptions8 = subscriptionsDAO.addSubscriptions(new Subscriptions(id8, unverifiedNotAdmin, now));
		Integer subscriptions9 = subscriptionsDAO.addSubscriptions(new Subscriptions(id9, verifiedNotAdmin, now));
		Integer subscriptions10 = subscriptionsDAO.addSubscriptions(new Subscriptions(id10, unverifiedNotAdmin, now));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
	}

}
