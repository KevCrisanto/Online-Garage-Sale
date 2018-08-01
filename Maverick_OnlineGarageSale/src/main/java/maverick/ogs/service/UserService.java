package maverick.ogs.service;

import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.UserAccountDAOImpl;

public class UserService {
	
	public static UserAccount userLogin(String username,String password) {
		UserAccountDAOImpl userDao = new UserAccountDAOImpl();
		UserAccount user = userDao.getAccountByUsername(username);
		if(user == null) return null;
		if(!user.getPassword().equals(password)) return null;		
		return user;
	}
	
	public static String insertNewUserAccount(UserAccount userAccount) {
		UserAccountDAOImpl uad = new UserAccountDAOImpl();
		return uad.insertAccount(userAccount);		
	}
	
}
