package maverick.ogs.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import maverick.ogs.beans.Address;
import maverick.ogs.dao.AddressDAO;
import maverick.ogs.dao.AddressDAOImpl;

public class AddressService {
	public static String insertNewAddress(Address address) {
		AddressDAO ad = new AddressDAOImpl();
		return ad.insertAddress(address);
	}
	
	public static Address selectAddressById(String id) {
		AddressDAO ad = new AddressDAOImpl();
		return ad.getAddressById(id);
	}
	
	public static String getAddressByIdJSON(String id) {
		Address address = selectAddressById(id);
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		
		try {
			json = mapper.writeValueAsString(address);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return json;
	}

}
