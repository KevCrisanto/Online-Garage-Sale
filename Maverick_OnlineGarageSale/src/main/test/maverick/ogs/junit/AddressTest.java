package maverick.ogs.junit;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import maverick.ogs.beans.Address;
import maverick.ogs.dao.AddressDAO;
import maverick.ogs.dao.AddressDAOImpl;

public class AddressTest {
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
}
