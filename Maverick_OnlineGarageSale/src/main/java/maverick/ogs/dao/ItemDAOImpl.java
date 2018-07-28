package maverick.ogs.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import maverick.ogs.beans.Item;
import maverick.ogs.util.HibernateUtil;

public class ItemDAOImpl implements ItemDAO {

	@Override
	public String insertItem(Item item) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		String id = null;
		
		try {
			transaction = session.beginTransaction();
			id = (String)session.save(item);
			transaction.commit();
		}
		catch(HibernateException e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		finally {
			session.close();
		}
		
		return id;
	}

	@Override
	public Item getItemById(String id) {
		Item item = null;
		Session session = HibernateUtil.getSession();
		
		try {
			item = (Item)session.get(Item.class, id);
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}		
		return item;
	}

	@Override
	public List<Item> getAllItems() {
		List<Item> items = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			items = session.createQuery("FROM item").list();
		}
		catch (HibernateException e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		finally {
			session.close();
		}		
		return items;
	}

	@Override
	public List<Item> getAllItemsByUserId(String accountId) {
		List<Item> items = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			items = session.createQuery("FROM item WHERE account_id = :id").list();
		}
		catch(HibernateException e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		finally {
			session.close();
		}		
		return items;
	}

	@Override
	public Boolean updateItemById(String itemId, Item i) {
		Item updateItem = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			updateItem = (Item)session.get(Item.class, itemId);
			if(updateItem != null) {
				if(i.getAccountId() != null) {
					updateItem.setAccountId(i.getAccountId());
				}
				if(i.getCategory() != null) {
					updateItem.setCategory(i.getCategory());
				}
				if(i.getDescription() != null) {
					updateItem.setDescription(i.getDescription());
				}
				if(i.getItemStatus() != null) {
					updateItem.setItemStatus(i.getItemStatus());
				}
				if(i.getPrice() != null) {
					updateItem.setPrice(i.getPrice());
				}
				session.save(updateItem);
				result = true;
			}
		}
		catch(HibernateException e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public Boolean deleteItemById(String itemId) {
		Item item = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean result = false;
		
		try {
			transaction = session.beginTransaction();
			item = (Item)session.get(Item.class, itemId);
			if(item != null) {
				session.delete(item);
				result = true;
			}
			transaction.commit();
		}
		catch(HibernateException e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		finally {
			session.close();
		}
		return result;
	}
	
}
