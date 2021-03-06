package maverick.ogs.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import maverick.ogs.beans.Transactions;
import maverick.ogs.beans.UserAccount;
import maverick.ogs.util.HibernateUtil;

public class TransactionsDAOImpl implements TransactionsDAO {

	@Override
	public String insertTransaction(maverick.ogs.beans.Transactions transactions) {
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
	public Boolean updateTransactionById(String transactionId, Transactions transactions) {
		Session session = HibernateUtil.getSession();
		Transaction hqlTransaction = null;
		Transactions transactionToUpdate = null;
		Boolean result = null;
		try {
			hqlTransaction = session.beginTransaction();
			transactionToUpdate = (Transactions)session.get(Transactions.class, transactionId);
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
					transactionToUpdate.setMemo(transactions.getMemo());
				}
				transactionToUpdate.setRating(transactions.getRating());
				transactionToUpdate.setPremrating(transactions.getPremrating());
				session.save(transactionToUpdate);
				hqlTransaction.commit();
				result = true;
			} 
			
	
		} catch (HibernateException e) {
			if(hqlTransaction != null) {
				hqlTransaction.rollback();
			}
		}finally {
			session.close();
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
			result = (maverick.ogs.beans.Transactions) session.createQuery("FROM Transactions where transactionId=\'" + transactionId + "\'").uniqueResult();
			
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
			hqlQueryResult = (maverick.ogs.beans.Transactions) session.createQuery("FROM Transactions where transactionId=\'" + transactionId + "\'").uniqueResult();
			
			if (hqlQueryResult != null) {
				// session.delete(hqlQueryResult);
				session.createSQLQuery("delete from transactions where transactionId=\'" + transactionId+ "\'").executeUpdate();
				transaction.commit();
				success = true;
			}
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
		
		return success;
	}
	
	@Override
	public Double getAvgRatingById(UserAccount seller) {
		Session session = HibernateUtil.getSession();
		Double avgRating = null;
		try {
			avgRating = (Double) session.createCriteria(Transactions.class)
					.add(Restrictions.eq("seller",seller)).add(Restrictions.gt("rating", -1))
					.setProjection(
					Projections.avg("rating")
					).uniqueResult();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		return avgRating;
	}
	
	@Override
	public Double getAvgPremRatingById(UserAccount seller) {
		Session session = HibernateUtil.getSession();
		Double avgRating = null;
		try {
			avgRating = (Double) session.createCriteria(Transactions.class)
					.add(Restrictions.eq("seller",seller)).add(Restrictions.gt("premrating", -1))
					.setProjection(
					Projections.avg("premrating")
					).uniqueResult();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		return avgRating;
	}
}