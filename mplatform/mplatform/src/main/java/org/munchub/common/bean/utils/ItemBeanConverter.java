package org.munchub.common.bean.utils;

import java.util.ArrayList;
import java.util.List;

import org.munchub.commons.utils.CollectionUtil;
import org.munchub.core.beans.Item;
import org.munchub.core.beans.ItemInfo;
import org.munchub.core.beans.ItemType;
import org.munchub.core.beans.Vendor;
import org.munchub.core.dao.ItemDAO;
import org.munchub.core.dao.VendorDAO;
import org.munchub.core.entity.ItemEntity;
import org.munchub.core.entity.ItemTypeEntity;
import org.munchub.core.entity.VendorEntity;

public class ItemBeanConverter {

	private ItemDAO itemDAO;
	private VendorDAO vendorDAO;

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	public void setVendorDAO(VendorDAO vendorDAO) {
		this.vendorDAO = vendorDAO;
	}

	public Item toItem(ItemEntity itemEntity){
		Item item = null;
		if(itemEntity != null){
			item = new Item();
			item.setId(itemEntity.getId());
			item.setName(itemEntity.getName());
			item.setOriginalPrice(itemEntity.getOriginalPrice());
			item.setDiscountedPrice(itemEntity.getDiscountedPrice());
			item.setOfferExpDate(itemEntity.getOfferExpiryDate());
			item.setIconPath(itemEntity.getIconPath());
			item.setItemType(toItemType(itemEntity.getItemType()));
			item.setVendor(toVendor(itemEntity.getVendor()));
		}
		return item;
	}

	public ItemEntity toItemEntity(Item item){
		ItemEntity itemEntity = null;
		if(item != null){
			itemEntity = new ItemEntity();
			itemEntity.setName(item.getName());
			itemEntity.setIconPath(item.getIconPath());
			itemEntity.setOriginalPrice(item.getOriginalPrice());
			itemEntity.setDiscountedPrice(item.getDiscountedPrice());
			itemEntity.setOfferExpiryDate(item.getOfferExpDate());

			ItemTypeEntity itemType = itemDAO.getItemTypeById(item.getItemType().getId());
			itemEntity.setItemType(itemType);

			VendorEntity vendor = vendorDAO.getVendorById(item.getVendor().getId());
			itemEntity.setVendor(vendor);
		}		
		return itemEntity;		
	}

	public List<Item> toItems(List<ItemEntity> lstItemEntity){
		List<Item> lstItem = null;
		if(!CollectionUtil.isEmpty(lstItemEntity)){
			lstItem = new ArrayList<Item>();
			for (ItemEntity itemEntity: lstItemEntity) {
				lstItem.add(toItem(itemEntity));					
			}
		}
		return lstItem;
	}

	private ItemType toItemType(ItemTypeEntity typeEntity){
		ItemType type = new ItemType();
		type.setId(typeEntity.getId());
		type.setName(typeEntity.getType());
		return type;
	}	

	private Vendor toVendor(VendorEntity vendorEntity){
		Vendor vendor = new Vendor();
		vendor.setId(vendorEntity.getId());
		vendor.setName(vendorEntity.getName());
		return vendor;
	}

	public List<ItemInfo> convertItemEntityListToSiteInfo(List<ItemEntity> lstItemEntity){
		List<ItemInfo> lstItem = null;
		if(!CollectionUtil.isEmpty(lstItemEntity)){
			lstItem = new ArrayList<ItemInfo>();
			for (ItemEntity itemEntity: lstItemEntity) {
				lstItem.add(toItemInfo(itemEntity));					
			}
		}
		return lstItem;
	}
	
	private ItemInfo toItemInfo(ItemEntity itemEntity){
		ItemInfo item = null;
		if(itemEntity != null){
			item = new ItemInfo();
			item.setId(itemEntity.getId());
			item.setName(itemEntity.getName());
			item.setOriginalPrice(itemEntity.getOriginalPrice());
			item.setDiscountedPrice(itemEntity.getDiscountedPrice());
			item.setOfferExpDate(itemEntity.getOfferExpiryDate());
			item.setIconPath(itemEntity.getIconPath());
			item.setItemType((itemEntity.getItemType().getType()));
			item.setVendorId(itemEntity.getVendor().getId().toString());
			item.setVendorName(itemEntity.getVendor().getName());
		}
		return item;		
	}
}
