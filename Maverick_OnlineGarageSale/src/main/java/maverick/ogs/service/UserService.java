package maverick.ogs.service;

import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.UserAccountDAOImpl;

public class UserService {
	
	public static boolean userLogin(String username,String password) {
		UserAccountDAOImpl userDao = new UserAccountDAOImpl();
		UserAccount user;
		if((user = userDao.getAccountByUsername(username)) == null) {
			return false;
		}
		if(!user.getPassword().equals(password)) {
			return false;
		}
		return true;
	}
}
