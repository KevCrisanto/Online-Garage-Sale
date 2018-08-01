package maverick.ogs.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import maverick.ogs.beans.Item;
import maverick.ogs.beans.Transactions;
import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.ItemDAO;
import maverick.ogs.dao.ItemDAOImpl;
import maverick.ogs.dao.TransactionsDAO;
import maverick.ogs.dao.TransactionsDAOImpl;
import maverick.ogs.dao.UserAccountDAO;
import maverick.ogs.dao.UserAccountDAOImpl;
import maverick.ogs.util.HibernateUtil;

public class TransactionsTest {
	@Test
	public void insertTransactionsTest() {
		Date now = new Date();
		
		TransactionsDAO transactionsDAO = new TransactionsDAOImpl();
		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
		ItemDAO itemDAO = new ItemDAOImpl();
		UserAccount buyer = null;
		UserAccount seller = null;
		
		if (userAccountDAO.getAccountByUsername("buyer") == null) {
			buyer = new UserAccount("buyer","testPassword","Tom","Earl", "tearl@email.com", now, true, true, false, true);
			userAccountDAO.insertAccount(buyer);
		} else {
			buyer = userAccountDAO.getAccountByUsername("buyer");
		}
		
		if (userAccountDAO.getAccountByUsername("seller") == null) {
			seller = new UserAccount("seller", "testPassword", "Jess", "Dancer", "jdancer@email.com", now, true, true, false, true);
			userAccountDAO.insertAccount(seller);
		} else {
			seller = userAccountDAO.getAccountByUsername("seller");
		}
		
		
		Float price = new Float(1.0);
		
		Item item = new Item(buyer, "Socks", "Backstock", price, "Clothes");
		
		String itemId = (String) itemDAO.insertItem(item);
		
		String transactionId = (String) transactionsDAO.insertTransaction(new Transactions(buyer, seller, itemDAO.getItemById(itemId), price, "Credit card withdrawal delayed as item is not available."));
	
		assertNotNull(transactionId);
	}
	
	@Test
	public void deleteTransactionsTest() {
		Date now = new Date();
		
		TransactionsDAO transactionsDAO = new TransactionsDAOImpl();
		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
		ItemDAO itemDAO = new ItemDAOImpl();
		UserAccount buyer = null;
		UserAccount seller = null;
		
		if (userAccountDAO.getAccountByUsername("buyer") == null) {
			buyer = new UserAccount("buyer","testPassword","Tom","Earl", "tearl@email.com", now, true, true, false, true);
			userAccountDAO.insertAccount(buyer);
		} else {
			buyer = userAccountDAO.getAccountByUsername("buyer");
		}
		
		if (userAccountDAO.getAccountByUsername("seller") == null) {
			seller = new UserAccount("seller", "testPassword", "Jess", "Dancer", "jdancer@email.com", now, true, true, false, true);
			userAccountDAO.insertAccount(seller);
		} else {
			seller = userAccountDAO.getAccountByUsername("seller");
		}
		
		
		Float price = new Float(1.0);
		
		Item item = new Item(buyer, "Socks", "Backstock", price, "Clothes");
		
		String itemId = (String) itemDAO.insertItem(item);
		
		String transactionId = (String) transactionsDAO.insertTransaction(new Transactions(buyer, seller, itemDAO.getItemById(itemId), price, "Credit card withdrawal delayed as item is not available."));
	
		Boolean isDeleted = transactionsDAO.deleteTransactionById(transactionId);
		assertTrue(isDeleted);
	}
	
	@Test
	public void getTransactionsAnAccountHasByIdTest() {
		ItemDAO itemDAO = new ItemDAOImpl();
		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
		TransactionsDAO transactionsDAO = new TransactionsDAOImpl();
		UserAccount buyer = null;
		UserAccount seller = null;
		Date now = new Date();
		
		if (userAccountDAO.getAccountByUsername("buyer") == null) {
			buyer = new UserAccount("buyer","testPassword","Tom","Earl", "tearl@email.com", now, true, true, false, true);
			userAccountDAO.insertAccount(buyer);
		} else {
			buyer = userAccountDAO.getAccountByUsername("buyer");
		}
		
		if (userAccountDAO.getAccountByUsername("seller") == null) {
			seller = new UserAccount("seller", "testPassword", "Jess", "Dancer", "jdancer@email.com", now, true, true, false, true);
			userAccountDAO.insertAccount(seller);
		} else {
			seller = userAccountDAO.getAccountByUsername("seller");
		}
		
		Float price = new Float(1.0);
		
		Item item = new Item(buyer, "Socks", "Backstock", price, "Clothes");
		
		String itemId = (String) itemDAO.insertItem(item);
		
		String transactionId = (String) transactionsDAO.insertTransaction(new Transactions(buyer, seller, itemDAO.getItemById(itemId), price, "Credit card withdrawal delayed as item is not available."));
	
		List<Transactions> transactions = transactionsDAO.getTransactionsAnAccountHasById(buyer.getAccountId());
		
		assertNotNull(transactions);
	}
}
