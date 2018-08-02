package maverick.ogs.dao;

import java.util.List;

import maverick.ogs.beans.Item;

public interface ItemDAO {
	public String insertItem(Item item);
	public Item getItemById(String id);
	public List<Item> getAllItems();
	public List<Item> getAllItemsByUserId(String accountId);
	public Boolean updateItemById(String itemId, Item item);
	public Boolean deleteItemById(String itemId);
	public List<Item> getAllItemsForSale();

}