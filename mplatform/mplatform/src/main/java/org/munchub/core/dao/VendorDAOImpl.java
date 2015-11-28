package org.munchub.core.dao;

import java.util.List;

import org.munchub.core.entity.BusinessTypeEntity;
import org.munchub.core.entity.VendorEntity;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class VendorDAOImpl extends HibernateDaoSupport implements VendorDAO{

	@Override
	public long addVendor(VendorEntity vendorEntity) {
		return (Long) getHibernateTemplate().save(vendorEntity);
	}

	@Override
	public VendorEntity updateVendor(VendorEntity vendorEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVendor(VendorEntity vendorEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VendorEntity getVendorById(long vendorId) {
		return getHibernateTemplate().get(VendorEntity.class, vendorId);
	}

	@Override
	public List<VendorEntity> getVendors() {
		return (List<VendorEntity>) getHibernateTemplate().findByNamedQuery("getVendors");
	}

	@Override
	public List<VendorEntity> getNearByVendor(long distance, long latitube,
			long longitude) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessTypeEntity getBusinessType(long id) {
		return getHibernateTemplate().get(BusinessTypeEntity.class, id);
	}

}
