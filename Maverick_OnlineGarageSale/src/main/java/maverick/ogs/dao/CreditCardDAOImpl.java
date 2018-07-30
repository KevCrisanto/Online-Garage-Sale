package maverick.ogs.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import maverick.ogs.beans.CreditCard;
import maverick.ogs.beans.Tier;
import maverick.ogs.util.HibernateUtil;

public class CreditCardDAOImpl implements CreditCardDAO {

	@Override
	public String insertCreditCard(CreditCard creditCard) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		String id = null;
		
		try {
			transaction = session.beginTransaction();
			id  = (String) session.save(creditCard);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		
		return id;
	}

	@Override
	public List<CreditCard> getAllCards() {
		Session session = HibernateUtil.getSession();
		List<CreditCard> creditCards = null;
		
		try {
			creditCards = session.createQuery("FROM CreditCard").list();
		} catch (HibernateException e) {
		} finally {
			session.close();
		}
		
		return creditCards;
	}

	@Override
	public List<CreditCard> getCreditCardsUserHas(String accountId) {
		Session session = HibernateUtil.getSession();
		List<CreditCard> creditCards = null;
		
		try {
			creditCards = session.createQuery("FROM CreditCard where=accountId\'" + accountId + "\'").list();
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
		
		return creditCards;
	}

	@Override
	public Boolean updateCreditCardById(String creditCardId, CreditCard card) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		CreditCard updatedCreditCard = null;
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			updatedCreditCard = (CreditCard) session.createQuery("FROM CreditCard where cardNumber=\'" + creditCardId + "\'");
			
			if (updatedCreditCard != null) {
				if (card.getCardName() != null) {
					updatedCreditCard.setCardName(card.getCardName());
				}
				if (card.getCardNumber() != null) {
					updatedCreditCard.setCardNumber(card.getCardNumber());
				}
				if (card.getCvv() != null) {
					updatedCreditCard.setCvv(card.getCvv());
				}
				if (card.getExpiration() != null) {
					updatedCreditCard.setCvv(card.getCvv());
				}
				if (card.getAddress() != null) {
					updatedCreditCard.setAddress(card.getAddress());
				}
			}
			
			session.save(updatedCreditCard);
			result = true;
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public Boolean deleteCreditCardById(String creditCardId) {
		Boolean result = false;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		CreditCard creditCard = null;
		
		try {
			transaction = session.beginTransaction();
			creditCard = (CreditCard) session.createQuery("FROM CreditCard where cardNumber=\'" + creditCardId +  "\'");
			
			if (creditCard != null) {
				session.delete(creditCard);
				result = true;
			}
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
		
		return false;
	}

}
