package maverick.ogs.service;

import java.util.List;

import maverick.ogs.beans.Item;
import maverick.ogs.beans.Transactions;
import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.ItemDAO;
import maverick.ogs.dao.ItemDAOImpl;
import maverick.ogs.dao.TransactionsDAO;
import maverick.ogs.dao.TransactionsDAOImpl;
import maverick.ogs.dao.UserAccountDAO;
import maverick.ogs.dao.UserAccountDAOImpl;

public class TransactionsService {
	public static List<Transactions> getUserTransactions(UserAccount userAccount){
		TransactionsDAO transDAO = new TransactionsDAOImpl();
		return transDAO.getTransactionsAnAccountHasById(userAccount.getAccountId());
	}
	
	public static void submitTransaction(String buyer, String seller, String item) {
		UserAccountDAO uad = new UserAccountDAOImpl();
		ItemDAO itemDao = new ItemDAOImpl();
		TransactionsDAO transDao = new TransactionsDAOImpl();
		
		UserAccount buyerAccount = uad.getAccountById(buyer);
		UserAccount sellerAccount = uad.getAccountById(seller);
		Item itemObj = itemDao.getItemById(item);
		
		itemObj.setItemStatus("sold");
		itemDao.updateItemById(itemObj.getItemId(), itemObj);
		
		transDao.insertTransaction(new Transactions(buyerAccount, sellerAccount, itemObj,itemObj.getPrice(),
				"kevinture",-1,-1));
	}
	
	public static void updateTransactionRating(String transid,int rating) {
		TransactionsDAO transDao = new TransactionsDAOImpl();
		
		Transactions trans = transDao.getTransactionById(transid);
		if(trans.getBuyer().isPremium()) {
			trans.setPremrating(rating);
		}else {
			trans.setRating(rating);
		}
		transDao.updateTransactionById(transid, trans);
	}
	
	public static Double getAvgRating(String seller) {
		TransactionsDAO transDao = new TransactionsDAOImpl();
		UserAccountDAO uad = new UserAccountDAOImpl();
		Double avg = transDao.getAvgRatingById(uad.getAccountById(seller));
		if(avg != null) {
			return avg;
		}else {
			return -1.0;
		}
	}
	
	public static Double getAvgPremRating(String seller) {
		TransactionsDAO transDao = new TransactionsDAOImpl();
		UserAccountDAO uad = new UserAccountDAOImpl();
		Double avg = transDao.getAvgPremRatingById(uad.getAccountById(seller));
		if(avg != null) {
			return avg;
		}else {
			return -1.0;
		}
	}
}
