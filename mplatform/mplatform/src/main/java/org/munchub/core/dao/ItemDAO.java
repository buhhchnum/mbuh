package org.munchub.core.dao;

import java.util.List;

import org.munchub.core.entity.ItemEntity;
import org.munchub.core.entity.ItemTypeEntity;

public interface ItemDAO {
	
	public long addItem(ItemEntity itemEntity);
	public ItemEntity updateItem(ItemEntity itemEntity);
	public void deleteItem(ItemEntity itemEntity);
	public ItemEntity getItemById(long id);
	public List<ItemEntity> getItemsByVendor(long vendorId);
	public ItemTypeEntity getItemTypeById(long id);

}
