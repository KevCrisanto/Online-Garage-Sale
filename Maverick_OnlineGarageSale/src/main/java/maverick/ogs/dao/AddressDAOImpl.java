package maverick.ogs.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import maverick.ogs.beans.Address;
import maverick.ogs.util.HibernateUtil;

public class AddressDAOImpl implements AddressDAO {

	@Override
	public String insertAddress(Address address) {
		Session session = HibernateUtil.getSession();
		Transaction transaction  = null;
		String addressId = null;
		
		try {
			transaction = session.beginTransaction();
			addressId = (String) session.save(address);
			transaction.commit();
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
		
		return addressId;
	}

	@Override
	public Address getAddressById(String id) {
		Session session = HibernateUtil.getSession();
		Address address = null;
		
		try {
			if (id != null) {
				address = (Address) session.createQuery("FROM Address where addressId=\'" + id + "\'").uniqueResult();
			}
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
		
		return address;
	}

	@Override
	public Boolean deleteAddressById(String id) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Address address = null;
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			address = (Address) session.createQuery("FROM Address where addressId=\'" + id + "\'" ).uniqueResult();
			if (address != null) {
				session.delete(address);
				result = true;
			}
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
		
		return result;
	}
}
