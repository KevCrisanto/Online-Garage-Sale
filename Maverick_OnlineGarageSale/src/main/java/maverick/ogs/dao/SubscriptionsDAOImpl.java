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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subscriptions updateSubscriptions(String userId, Subscriptions subscriptions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteSubscriptionById(String userId, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
