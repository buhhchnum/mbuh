package org.munchub.core.service;

import java.util.List;

import org.munchub.core.beans.Item;
import org.munchub.core.beans.ItemInfo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
public interface ItemService {
	
	public Item addItem(Item item);
	public Item updateItem(Item item);
	public void deleteItem(long id);
	public Item getItemById(long id);
	public List<ItemInfo> getItemsByVendor(long vendorId);

}
