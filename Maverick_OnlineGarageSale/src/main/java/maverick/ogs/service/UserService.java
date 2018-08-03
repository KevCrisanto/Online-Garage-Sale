package maverick.ogs.service;











import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.UserAccountDAO;
import maverick.ogs.dao.UserAccountDAOImpl;

public class UserService {	
	public static UserAccount userLogin(String username,String password) {
		Logger logger = LoggerFactory.getLogger(UserService.class.getName());
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
	
}
