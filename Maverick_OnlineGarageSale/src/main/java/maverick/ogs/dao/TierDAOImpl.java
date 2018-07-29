package maverick.ogs.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import maverick.ogs.beans.Tier;
import maverick.ogs.beans.UserAccount;
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
			 transaction = session.beginTransaction();
			 tiers = session.createQuery("FROM Tier").list();
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
	public Boolean updateTier(Tier tier) {
		Tier updatedTier = null;
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			updatedTier = (Tier) session.get(tier.getClass(), tier.getTier_id());
			if (updatedTier != null) {
				if(tier.getName() != null) {
					updatedTier.setName(tier.getName());
				}
				
				session.save(updatedTier);
				result = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Tier getTierById(Integer id) {
		Tier tier = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			tier = (Tier) session.createQuery("FROM Tier where tier_id=\'" 
											+ id + "\'").uniqueResult();
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
