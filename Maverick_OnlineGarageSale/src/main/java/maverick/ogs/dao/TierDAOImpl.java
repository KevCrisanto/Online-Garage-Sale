package maverick.ogs.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import maverick.ogs.beans.Tier;
import maverick.ogs.util.HibernateUtil;

public class TierDAOImpl implements TierDAO {

	@Override
	public Integer addTier(Tier tier) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Integer id = null;
		
		try {
			transaction = session.beginTransaction();
			id = (Integer)session.save(tier);
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
	public List<Tier> getAllTiers() {
		List<Tier> tiers = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		 try {
			 
		 } catch (HibernateException e) {
			 if (transaction != null) {
				 transaction.rollback();
			 }
		 } finally {
			 session.close();
		 }
		 
		 return tiers;
	}

	@Override
	public Tier updateTier(Tier tier) {
		Tier updatedTier = null;
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			updatedTier = (Tier) session.get(tier.getClass(), tier.getId());
			if (updatedTier != null) {
				if(tier.getName() != null) {
					updatedTier.setName(tier.getName());
				}
				
				session.save(updatedTier);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return tier;
	}

	@Override
	public Tier getTierById(Integer id) {
		Tier tier = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			tier = (Tier) HibernateUtil.getSession();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return tier;
	}

	@Override
	public Boolean deleteTierById(Integer id) {
		Tier tier = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			tier = (Tier) session.get(Tier.class, id);
			
			if (tier != null) {
				session.delete(tier);
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

}
