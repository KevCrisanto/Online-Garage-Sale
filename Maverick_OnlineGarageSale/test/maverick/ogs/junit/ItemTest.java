package maverick.ogs.junit;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import maverick.ogs.beans.Item;
import maverick.ogs.beans.UserAccount;
import maverick.ogs.dao.ItemDAO;
import maverick.ogs.dao.ItemDAOImpl;
import maverick.ogs.dao.UserAccountDAO;
import maverick.ogs.dao.UserAccountDAOImpl;
import maverick.ogs.util.HibernateUtil;

public class ItemTest {	
	
	@After
	public void tearDown() throws Exception{
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.createSQLQuery("TRUNCATE TABLE item").executeUpdate();
			
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
	
	@AfterClass
	public static void destroy() {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.createSQLQuery("DROP TABLE user_account CASCADE CONSTRAINTS").executeUpdate();
			
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
	public void InsertItemTest() {
		ItemDAO id = new ItemDAOImpl();
		Date now = new Date();
		
		Item mockItem = new Item();
		String mockId = id.insertItem(mockItem);			
		assertEquals(mockId, mockItem.getItemId());
		
		UserAccount mockua = new UserAccount("kkay", "password", "Kristina", "Kay", "kkay@email.com", now, false, false, false, false);
		UserAccountDAO uad = new UserAccountDAOImpl();
		uad.insertAccount(mockua);
		
		Item mockItem2 = new Item(mockua, "", "", 10.0F, "");
		String mockId2 = id.insertItem(mockItem2);
		assertEquals(mockId2, mockItem2.getItemId());		
	}
	
	@Test
	public void getItemByIdTest() {
		ItemDAO id = new ItemDAOImpl();
		
		Item mockItem = new Item();
		String insertId = id.insertItem(mockItem);
		
		Item retrievedItem = id.getItemById(insertId);
		
		assertEquals(mockItem.getItemId(), retrievedItem.getItemId());
	}
	
	@Test
	public void getAllItemsTest() {
		ItemDAO id = new ItemDAOImpl();
		
		Item mockItem = new Item();
		Item mockItem2 = new Item();
		Item mockItem3 = new Item();
		Item mockItem4 = new Item();
		Item mockItem5 = new Item();
		id.insertItem(mockItem);
		id.insertItem(mockItem2);
		id.insertItem(mockItem3);
		id.insertItem(mockItem4);
		id.insertItem(mockItem5);
		
		int size = id.getAllItems().size();
				
		assertEquals(5, size);		
	}
	
	@Test
	public void getAllItemsByUserIdTest() {
		ItemDAO id = new ItemDAOImpl();
		Date now = new Date();
		
		UserAccount mockua = new UserAccount("admin", "password", "admin", "istrator", "admin@email.com", now, false, false, false, false);
		UserAccountDAO uad = new UserAccountDAOImpl();
		uad.insertAccount(mockua);
		
		Item mockItem = new Item(mockua, "", "", 10.0F, "");
		Item mockItem2 = new Item(mockua, "", "", 10.0F, "");
		Item mockItem3 = new Item(mockua, "", "", 10.0F, "");
		Item mockItem4 = new Item(mockua, "", "", 10.0F, "");
		Item mockItem5 = new Item(mockua, "", "", 10.0F, "");
		
		id.insertItem(mockItem);
		id.insertItem(mockItem2);
		id.insertItem(mockItem3);
		id.insertItem(mockItem4);
		id.insertItem(mockItem5);
		
		int size = id.getAllItemsByUserId(mockua.getAccountId()).size();
		
		assertEquals(5, size);
	}
	
	@Test
	 public void updateItemByIdTest() {
		 ItemDAO id = new ItemDAOImpl();
		 
		 Item mockItem = new Item();
		 id.insertItem(mockItem);
		 System.err.println(mockItem.getItemId());
		 
		 Item mockItem2 = new Item(null, "testDes", "testStat", 15F, "testCat");
		 Boolean result = id.updateItemById(mockItem.getItemId(), mockItem2);
		 
		 Item updatedItem = id.getItemById(mockItem.getItemId());
		 System.err.println(updatedItem.getItemId());
		 
		 assertEquals(true, result);
		 assertEquals(updatedItem.getAccountId(), null);
		 assertEquals(updatedItem.getDescription(), "testDes");
		 assertEquals(updatedItem.getItemStatus(), "testStat");
		 assertEquals(updatedItem.getPrice(), mockItem2.getPrice());
		 assertEquals(updatedItem.getCategory(), "testCat");		 
	 }
	
	@Test
	public void deleteItemByIdTest() {
		ItemDAO id = new ItemDAOImpl();
		
		Item mockItem = new Item();
		id.insertItem(mockItem);
		
		Boolean result = id.deleteItemById(mockItem.getItemId());
		assertEquals(true, result);
	}

}
