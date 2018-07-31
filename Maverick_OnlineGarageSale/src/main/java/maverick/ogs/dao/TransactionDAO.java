package maverick.ogs.dao;

import java.util.List;

import maverick.ogs.beans.Transaction;

public interface TransactionDAO {
	public String insertTransaction(Transaction transaction);
	public List<Transaction> getAllTransactions();
	public Boolean updateTransactionById(String transactionId, Transaction transaction);
	public Transaction getTransactionById(String transactionId);
	public Boolean deleteTransactionById(String transactionId);
}
