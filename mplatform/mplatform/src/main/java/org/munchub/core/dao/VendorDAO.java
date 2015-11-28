package org.munchub.core.dao;

import java.util.List;

import org.munchub.core.entity.BusinessTypeEntity;
import org.munchub.core.entity.VendorEntity;

public interface VendorDAO {
	
	public long addVendor(VendorEntity vendorEntity);
	public VendorEntity updateVendor(VendorEntity vendorEntity);
	public void deleteVendor(VendorEntity vendorEntity);
	public VendorEntity getVendorById(long vendorId);
	public List<VendorEntity> getVendors();
	public List<VendorEntity> getNearByVendor(long distance, long latitube, long longitude);
	public BusinessTypeEntity getBusinessType(long id);

}
