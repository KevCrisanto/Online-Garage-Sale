package maverick.ogs.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import maverick.ogs.beans.Subscriptions;
import maverick.ogs.beans.Tier;
import maverick.ogs.util.HibernateUtil;

public class SubscriptionsDAOImpl implements SubscriptionsDAO {

	@Override
	public Integer addSubscriptions(Subscriptions subscriptions) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Integer id = null;
		
		try {
			transaction = session.beginTransaction();
			id = (Integer) session.save(subscriptions);
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
	public List<Subscriptions> getAllSubscriptions() {
		List<Subscriptions> subscriptions = null;
		Session session= HibernateUtil.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			subscriptions = session.createQuery("FROM subscriptions").list();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		
		return subscriptions; 
	}

	@Override
	public Boolean updateSubscriptions(Subscriptions subscriptions) {
		Subscriptions updatedSubscriptions = null;
		Transaction transaction = null;
		Session session = HibernateUtil.getSession();
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			updatedSubscriptions = (Subscriptions) session.get(subscriptions.getClass(), subscriptions.getId());
			
			if (updatedSubscriptions != null) {
				if (subscriptions.getUserId() != null) {
					updatedSubscriptions.setUserId(subscriptions.getUserId());
				}
				
				if (subscriptions.getSubscriptionEndDate() != null) {
					updatedSubscriptions.setSubscriptionEndDate(subscriptions.getSubscriptionEndDate());
				}
			}
			result = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Boolean deleteSubscriptionsById(String id) {
		Subscriptions deletedSubscriptions = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			deletedSubscriptions = (Subscriptions) session.get(Subscriptions.class, id);
			
			if (deletedSubscriptions != null) {
				session.delete(deletedSubscriptions);
				result = true;
			}
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public Boolean deleteSubscriptions(Subscriptions subscriptions) {
		Subscriptions deletedSubscriptions = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			deletedSubscriptions = (Subscriptions) session.get(subscriptions.getClass(), subscriptions.getId());
			
			if (deletedSubscriptions != null) {
				session.delete(deletedSubscriptions);
				result = true;
			}
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public Subscriptions addTier(Subscriptions subscriptions, Tier tier) {
		Tier hibernateTier = null;
		Subscriptions updatedSubscriptions = null;
		List<Tier> tiers = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Integer subscriptionId = null;
		
		try {
			transaction = session.getTransaction();
			updatedSubscriptions = (Subscriptions) session.get(subscriptions.getClass(), subscriptions.getId());
			hibernateTier = (Tier) session.get(tier.getClass(), tier.getId());
			
			if (hibernateTier != null && updatedSubscriptions != null) {
				tiers = updatedSubscriptions.getTiers();
				tiers.add(hibernateTier);
				updatedSubscriptions.setTiers(tiers);
				subscriptionId = (Integer) session.save(updatedSubscriptions);
			}
			
			if (subscriptionId == null) {
				return null;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return updatedSubscriptions;
	}

}
