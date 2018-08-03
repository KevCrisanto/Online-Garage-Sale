package maverick.ogs.service;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

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
	
	public static List<UserAccount> getAllUsers(){
		UserAccountDAO userDao = new UserAccountDAOImpl();
		return userDao.getAllAccounts();
	}
	
	public static String getAllUsersJSON() {
		List<UserAccount> users = getAllUsers();
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		
		try {
			json = mapper.writeValueAsString(users);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public static Boolean deleteUserById(String id) {
		UserAccountDAO userDao = new UserAccountDAOImpl();
		return userDao.deleteAccountById(id);
	}
	
}
