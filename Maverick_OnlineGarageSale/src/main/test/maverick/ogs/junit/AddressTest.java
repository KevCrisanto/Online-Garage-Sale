package maverick.ogs.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Test;

import maverick.ogs.beans.Address;
import maverick.ogs.dao.AddressDAO;
import maverick.ogs.dao.AddressDAOImpl;
import maverick.ogs.util.HibernateUtil;

public class AddressTest {
	@After
	public void tearDown() throws Exception{
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.createSQLQuery("TRUNCATE TABLE address").executeUpdate();
			
			tx.commit();
		}
		catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
		}
		finally {
			session.close();
		}
	}
	
	@Test
	public void insertAddressTest() {
		AddressDAO addressDAO = new AddressDAOImpl();
		String address1 = (String) addressDAO.insertAddress(new Address("Turtle Ave.", // address line 1
															   "", // address line 2
															   "14A", // apt number
															   "", // post office box
															   "Arlington", // city
															   "TX", // state
															   "United States", //country
															   "76013")); //zipcode
		System.out.println(address1);
		assertNotNull(address1);
	}
	
	@Test
	public void getAddressByIdTest() {
		AddressDAO addressDAO = new AddressDAOImpl();
		String address1 = (String) addressDAO.insertAddress(new Address("Turtley Ave.", // address line 1
				   "", // address line 2
				   "14A", // apt number
				   "", // post office box
				   "Arlington", // city
				   "TX", // state
				   "United States", //country
				   "76013")); //zipcode
		Address address = (Address) addressDAO.getAddressById(address1);
		System.out.println(address1);
		assertNotNull(address);
	}
	
	@Test
	public void deleteAddressByIdTest() {
		AddressDAO addressDAO = new AddressDAOImpl();
		String addressId = (String) addressDAO.insertAddress(new Address("Turtley Ave.", // address line 1
				   "", // address line 2
				   "14A", // apt number
				   "", // post office box
				   "Arlington", // city
				   "TX", // state
				   "United States", //country
				   "76013")); //zipcode
		Address address = (Address) addressDAO.getAddressById(addressId);
		Boolean returnedTrue = addressDAO.deleteAddressById(addressId);
		assertTrue(returnedTrue);
	}
}
