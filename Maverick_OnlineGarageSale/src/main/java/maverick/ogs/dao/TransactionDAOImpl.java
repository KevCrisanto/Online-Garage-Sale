package maverick.ogs.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import maverick.ogs.util.HibernateUtil;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public String insertTransaction(maverick.ogs.beans.Transactions transaction) {
		Session session = HibernateUtil.getSession();
		Transaction hqlTransaction = null;
		String transactionId = null;
		
		try {
			hqlTransaction = session.beginTransaction();
			transactionId = (String) session.save(transaction);
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
			transactions = session.createQuery("FROM Transaction").list();
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
		
		return transactions;
	}

	@Override
	public Boolean updateTransactionById(String transactionId, maverick.ogs.beans.Transactions transaction) {
		Session session = HibernateUtil.getSession();
		Transaction hqlTransaction = null;
		maverick.ogs.beans.Transactions transactionToUpdate = (maverick.ogs.beans.Transactions) session.createQuery("FROM Transaction where transactionId=\'" + transactionId + "\'");
		Boolean result = null;
		try {
			hqlTransaction = session.beginTransaction();
			
			if (transaction != null) {
				if (transaction.getTransactionId() != null) {
					transactionToUpdate.setTransactionId(transaction.getTransactionId());
				}
				if (transaction.getSeller() != null) {
					transactionToUpdate.setSeller(transaction.getSeller());
				}
				if (transaction.getBuyer() != null) {
					transactionToUpdate.setBuyer(transaction.getBuyer());
				}
				if (transaction.getItem() != null) {
					transactionToUpdate.setItem(transaction.getItem());
				}
				if (transaction.getTransactionAmount() != null) {
					transactionToUpdate.setTransactionAmount(transaction.getTransactionAmount());
				}
				if (transaction.getMemo() != null) {
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
			result = (maverick.ogs.beans.Transactions) session.createQuery("FROM Transaction where=\'" + transactionId + "\'").uniqueResult();
			
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
			hqlQueryResult = (maverick.ogs.beans.Transactions) session.createQuery("FROM Transaction where transactionId=\'" + transactionId + "\'").uniqueResult();
			session.remove(hqlQueryResult);
			transaction.commit();
			success = true;
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
		
		return success;
	}

}
