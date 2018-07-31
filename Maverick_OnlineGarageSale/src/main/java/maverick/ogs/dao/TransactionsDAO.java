package maverick.ogs.dao;

import java.util.List;

import maverick.ogs.beans.Transactions;

public interface TransactionsDAO {
	public String insertTransaction(Transactions transactions);
	public List<Transactions> getAllTransactions();
	public List<Transactions> getTransactionsAnAccountHasById(String accountId);
	public Boolean updateTransactionById(String transactionId, Transactions transactions);
	public Transactions getTransactionById(String transactionId);
	public Boolean deleteTransactionById(String transactionId);
}
