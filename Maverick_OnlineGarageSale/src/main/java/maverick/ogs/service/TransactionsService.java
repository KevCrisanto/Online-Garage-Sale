package maverick.ogs.service;

import java.util.List;

import maverick.ogs.beans.Transactions;
import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.TransactionsDAO;
import maverick.ogs.dao.TransactionsDAOImpl;

public class TransactionsService {
	public static List<Transactions> getUserTransactions(UserAccount userAccount){
		TransactionsDAO transDAO = new TransactionsDAOImpl();
		return transDAO.getAllTransactions();
	}
}
