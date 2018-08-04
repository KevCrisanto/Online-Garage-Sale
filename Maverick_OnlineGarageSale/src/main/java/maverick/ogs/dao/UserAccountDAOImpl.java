package maverick.ogs.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import maverick.ogs.beans.UserAccount;
import maverick.ogs.util.HibernateUtil;

public class UserAccountDAOImpl implements UserAccountDAO {

	@Override
	public String insertAccount(UserAccount account) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		String id = null;
		
		try {
			transaction = session.beginTransaction();
			id = (String)session.save(account);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		
		return id;
	}

	@Override
	public List<UserAccount> getAllAccounts() {
		List<UserAccount> accounts = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			accounts = session.createQuery("FROM UserAccount").list();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return accounts;
	}

	@Override
	public Boolean updateAccountById(String id, UserAccount account) {
		UserAccount updatedAccount = null;
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			updatedAccount = (UserAccount) session.createQuery("FROM UserAccount where account_id=\'" + id + "\'").uniqueResult();
			
			if (updatedAccount != null) {
				if (account.getFirstName() != null) {
					updatedAccount.setFirstName(account.getFirstName());
				}
					
				if (account.getLastName() != null) {
					updatedAccount.setLastName(account.getLastName());
				}
				
				if (account.getEmail() != null) {
					updatedAccount.setEmail(account.getEmail());
				}
				
				if (account.getPassword() != null) {
					updatedAccount.setPassword(account.getPassword());
				}
				
				session.save(updatedAccount);
				transaction.commit();
				result = true;
			}
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public UserAccount getAccountById(String id) {
		UserAccount account = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			account = (UserAccount) session.createQuery("FROM UserAccount where account_id=\'" + id + "\'").uniqueResult();
			if (id != null) {
				account = (UserAccount) session.get(UserAccount.class, id);
				return account;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return account;
	}

	@Override
	public Boolean deleteAccountById(String id) {
		UserAccount account = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			account = (UserAccount) session.createQuery("FROM UserAccount where account_id=\'" + id + "\'").uniqueResult();
			if (account != null) {
				session.delete(account);
				result = true;
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public UserAccount getAccountByUsername(String username) {
		UserAccount account = null;
		Session session = HibernateUtil.getSession();
		
		try {
			if (username != null) {

				account = (UserAccount) session.createQuery("FROM UserAccount where username=\'" + username + "\'").uniqueResult();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close(); 
		}
		return account;
	}
	
	@Override
	public Boolean deleteAccountByUsername(String username) {
		UserAccount account = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			account = (UserAccount) session.createQuery("FROM UserAccount where username=\'" + username + "\'").uniqueResult();
		
			if (account != null) {
				session.delete(account);
				result = true;
			}
			
			transaction.commit();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return result;
	}
	
//	public static void main(String[] args) {
//		UserAccountDAO userAccountDAO = new UserAccountDAOImpl();
//		Date now = new Date();
//
//		String id1 = userAccountDAO.insertAccount(new UserAccount("kkay", "password", "Kristina", "Kay", "kkay@email.com", now, false, false, false, false));
//		
//		System.out.println(userAccountDAO.getAllAccounts());
//	}

}
