package maverick.ogs.junit;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import maverick.ogs.beans.Item;
import maverick.ogs.beans.Transaction;
import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.ItemDAO;
import maverick.ogs.dao.ItemDAOImpl;
import maverick.ogs.dao.TransactionDAO;
import maverick.ogs.dao.TransactionDAOImpl;
import maverick.ogs.dao.UserAccountDAO;
import maverick.ogs.dao.UserAccountDAOImpl;

public class TransactionTest {
	@Test
	public void InsertTransactionTest() {
		Date now = new Date();
		
		TransactionDAO transactionDAO = new TransactionDAOImpl();
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
		
		String transactionId = (String) transactionDAO.insertTransaction(new Transaction(buyer, seller, itemDAO.getItemById(itemId), price, "Credit card withdrawal delayed as item is not available."));
	
		assertNotNull(transactionId);
	}
}
