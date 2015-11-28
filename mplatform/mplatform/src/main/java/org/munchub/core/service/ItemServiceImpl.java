package org.munchub.core.service;

import java.util.List;

import org.munchub.common.bean.utils.ItemBeanConverter;
import org.munchub.core.beans.Item;
import org.munchub.core.beans.ItemInfo;
import org.munchub.core.dao.ItemDAO;
import org.munchub.core.entity.ItemEntity;

public class ItemServiceImpl implements ItemService{
	
	private ItemDAO itemDAO;
	private ItemBeanConverter itemBeanConverter;
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public void setItemBeanConverter(ItemBeanConverter itemBeanConverter) {
		this.itemBeanConverter = itemBeanConverter;
	}

	@Override
	public Item addItem(Item item) {
		ItemEntity itemEntity = itemBeanConverter.toItemEntity(item);
		long itemID = itemDAO.addItem(itemEntity);
		item = itemBeanConverter.toItem(itemDAO.getItemById(itemID));
		return item;
	}

	@Override
	public Item updateItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteItem(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item getItemById(long id) {
		ItemEntity itemEntity = itemDAO.getItemById(id);
		Item item = itemBeanConverter.toItem(itemEntity);
		return item;
	}

	@Override
	public List<ItemInfo> getItemsByVendor(long vendorId) {
		List<ItemEntity> lstItemEntity = itemDAO.getItemsByVendor(vendorId);
		List<ItemInfo> lstItems = itemBeanConverter.convertItemEntityListToSiteInfo(lstItemEntity);
		return lstItems;
	}

}
