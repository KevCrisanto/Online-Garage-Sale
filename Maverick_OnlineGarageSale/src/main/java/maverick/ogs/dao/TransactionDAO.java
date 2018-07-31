package maverick.ogs.dao;

import java.util.List;

import maverick.ogs.beans.Transactions;

public interface TransactionDAO {
	public String insertTransaction(Transactions transaction);
	public List<Transactions> getAllTransactions();
	public Boolean updateTransactionById(String transactionId, Transactions transaction);
	public Transactions getTransactionById(String transactionId);
	public Boolean deleteTransactionById(String transactionId);
}
