package maverick.ogs.service;

import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.UserAccountDAO;
import maverick.ogs.dao.UserAccountDAOImpl;

public class UserService {
	
	public static UserAccount userLogin(String username,String password) {
		UserAccountDAO userDao = new UserAccountDAOImpl();
		UserAccount user = userDao.getAccountByUsername(username);
		if(user == null) return null;
		if(!user.getPassword().equals(password)) return null;		
		return user;
	}
	
	public static String insertNewUserAccount(UserAccount userAccount) {
		UserAccountDAO userDao = new UserAccountDAOImpl();
		return userDao.insertAccount(userAccount);		
	}
	
	public static UserAccount getUserById(String id) {
		UserAccountDAO userDao = new UserAccountDAOImpl();
		return userDao.getAccountById(id);
	}
	
	public static Boolean updateUserById(String id, UserAccount account) {
		UserAccountDAO userDao = new UserAccountDAOImpl();
		return userDao.updateAccountById(id, account);
	}
	
}
