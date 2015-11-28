package org.munchub.core.dao;

import java.util.List;

import org.munchub.core.entity.ItemEntity;
import org.munchub.core.entity.ItemTypeEntity;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class ItemDAOImpl extends HibernateDaoSupport implements ItemDAO{

	@Override
	public long addItem(ItemEntity itemEntity) {
		return (Long) getHibernateTemplate().save(itemEntity);
	}

	@Override
	public ItemEntity updateItem(ItemEntity itemEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteItem(ItemEntity itemEntity) {
		getHibernateTemplate().delete(itemEntity);
	}

	@Override
	public ItemEntity getItemById(long id) {
		return (ItemEntity) getHibernateTemplate().get(ItemEntity.class, id);
	}

	@Override
	public List<ItemEntity> getItemsByVendor(long vendorId) {
		 	String paramNames[] = { "vendorId"};
	        Object paramValues[] = { vendorId };
	        List<ItemEntity> items = (List<ItemEntity>) getHibernateTemplate().findByNamedQueryAndNamedParam("getItemsByVendor", paramNames, paramValues);
	        return items;
	}

	@Override
	public ItemTypeEntity getItemTypeById(long id) {
		return (ItemTypeEntity) getHibernateTemplate().get(ItemTypeEntity.class, id);
	}
	

}
