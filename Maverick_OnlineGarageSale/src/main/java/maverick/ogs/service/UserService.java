package maverick.ogs.service;

import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.UserAccountDAOImpl;

public class UserService {
	
	public static UserAccount userLogin(String username,String password) {
		UserAccountDAOImpl userDao = new UserAccountDAOImpl();
		UserAccount user = userDao.getAccountByUsername(username);
		return user;
	}
	
}
