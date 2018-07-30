package maverick.ogs.junit;

import java.util.Date;

import org.junit.Test;

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
		
		UserAccount buyer = new UserAccount("buyer","testPassword","Tom","Earl", "tearl@email.com", now, true, true, false, true);
		UserAccount seller = new UserAccount("seller", "testPassword", "Jess", "Dancer", "jdancer@email.com", now, true, true, false, true);
		
		Item item = new Item()
		
		String buyerId = (String) userAccountDAO.insertAccount(buyer);
		String sellerId = (String) userAccountDAO.insertAccount(seller);
		
		
		
		
		String transactionId = new transactionDAO.insertTransaction(new Transaction());
	}
}
