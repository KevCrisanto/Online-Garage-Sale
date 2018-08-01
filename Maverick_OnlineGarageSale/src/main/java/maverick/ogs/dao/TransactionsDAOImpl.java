package maverick.ogs.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import maverick.ogs.util.HibernateUtil;

public class TransactionsDAOImpl implements TransactionsDAO {

	@Override
<<<<<<< Updated upstream:Maverick_OnlineGarageSale/src/main/java/maverick/ogs/dao/TransactionsDAOImpl.java
	public String insertTransaction(maverick.ogs.beans.Transactions transactions) {
=======
	public String insertTransaction(maverick.ogs.beans.Transactions transaction) {
>>>>>>> Stashed changes:Maverick_OnlineGarageSale/src/main/java/maverick/ogs/dao/TransactionDAOImpl.java
		Session session = HibernateUtil.getSession();
		Transaction hqlTransaction = null;
		String transactionId = null;
		
		try {
			hqlTransaction = session.beginTransaction();
			transactionId = (String) session.save(transactions);
			hqlTransaction.commit();
		} catch (HibernateException e) {
			if (hqlTransaction != null) {
				hqlTransaction.rollback();
			}
		} finally {
			session.close();
		}
		
		return transactionId;
	}

	@Override
	public List<maverick.ogs.beans.Transactions> getAllTransactions() {
		Session session = HibernateUtil.getSession();
		List<maverick.ogs.beans.Transactions> transactions = null;
		
		try {
			transactions = session.createQuery("FROM Transactions").list();
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
		
		return transactions;
	}
	
	@Override
	public List<maverick.ogs.beans.Transactions> getTransactionsAnAccountHasById(String accountId) {
		Session session = HibernateUtil.getSession();
		List<maverick.ogs.beans.Transactions> transactions = null;
		
		try {
			transactions = session.createQuery("FROM Transactions where buyer=\'" + accountId + "\' or " + "seller=\'" + accountId + "\'").list();
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
		
		return transactions;
	}

	@Override
<<<<<<< Updated upstream:Maverick_OnlineGarageSale/src/main/java/maverick/ogs/dao/TransactionsDAOImpl.java
	public Boolean updateTransactionById(String transactionId, maverick.ogs.beans.Transactions transactions) {
		Session session = HibernateUtil.getSession();
		Transaction hqlTransaction = null;
		maverick.ogs.beans.Transactions transactionToUpdate = (maverick.ogs.beans.Transactions) session.createQuery("FROM Transactions where transactionId=\'" + transactionId + "\'");
=======
	public Boolean updateTransactionById(String transactionId, maverick.ogs.beans.Transactions transaction) {
		Session session = HibernateUtil.getSession();
		Transaction hqlTransaction = null;
		maverick.ogs.beans.Transactions transactionToUpdate = (maverick.ogs.beans.Transactions) session.createQuery("FROM Transaction where transactionId=\'" + transactionId + "\'");
>>>>>>> Stashed changes:Maverick_OnlineGarageSale/src/main/java/maverick/ogs/dao/TransactionDAOImpl.java
		Boolean result = null;
		try {
			hqlTransaction = session.beginTransaction();
			
			if (transactions != null) {
				if (transactions.getTransactionId() != null) {
					transactionToUpdate.setTransactionId(transactions.getTransactionId());
				}
				if (transactions.getSeller() != null) {
					transactionToUpdate.setSeller(transactions.getSeller());
				}
				if (transactions.getBuyer() != null) {
					transactionToUpdate.setBuyer(transactions.getBuyer());
				}
				if (transactions.getItem() != null) {
					transactionToUpdate.setItem(transactions.getItem());
				}
				if (transactions.getTransactionAmount() != null) {
					transactionToUpdate.setTransactionAmount(transactions.getTransactionAmount());
				}
				if (transactions.getMemo() != null) {
					transactionToUpdate.setMemo(transactionToUpdate.getMemo());
				}
				session.save(transactionToUpdate);
				hqlTransaction.commit();
				result = true;
			} 
			
	
		} catch (HibernateException e) {
			
		}
		
		return result;
	}

	@Override
	public maverick.ogs.beans.Transactions getTransactionById(String transactionId) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		maverick.ogs.beans.Transactions result = null;
		
		try {
			transaction = session.beginTransaction();
<<<<<<< Updated upstream:Maverick_OnlineGarageSale/src/main/java/maverick/ogs/dao/TransactionsDAOImpl.java
			result = (maverick.ogs.beans.Transactions) session.createQuery("FROM Transactions where=\'" + transactionId + "\'").uniqueResult();
=======
			result = (maverick.ogs.beans.Transactions) session.createQuery("FROM Transaction where=\'" + transactionId + "\'").uniqueResult();
>>>>>>> Stashed changes:Maverick_OnlineGarageSale/src/main/java/maverick/ogs/dao/TransactionDAOImpl.java
			
		} catch (HibernateException e) {
		} finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public Boolean deleteTransactionById(String transactionId) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		maverick.ogs.beans.Transactions hqlQueryResult = null;
		Boolean success = false;
		
		try {
			transaction = session.beginTransaction();
<<<<<<< Updated upstream:Maverick_OnlineGarageSale/src/main/java/maverick/ogs/dao/TransactionsDAOImpl.java
			hqlQueryResult = (maverick.ogs.beans.Transactions) session.createQuery("FROM Transactions where transactionId=\'" + transactionId + "\'").uniqueResult();
			
			if (hqlQueryResult != null) {
				// session.delete(hqlQueryResult);
				session.createSQLQuery("delete from transactions where transactionId=\'" + transactionId+ "\'").executeUpdate();
				transaction.commit();
				success = true;
			}
=======
			hqlQueryResult = (maverick.ogs.beans.Transactions) session.createQuery("FROM Transaction where transactionId=\'" + transactionId + "\'").uniqueResult();
			session.remove(hqlQueryResult);
			transaction.commit();
			success = true;
>>>>>>> Stashed changes:Maverick_OnlineGarageSale/src/main/java/maverick/ogs/dao/TransactionDAOImpl.java
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
		
		return success;
	}
}
