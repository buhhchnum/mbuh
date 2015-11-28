package org.munchub.core.service;

import java.util.List;

import org.munchub.common.bean.utils.VendorBeanConverter;
import org.munchub.core.beans.Vendor;
import org.munchub.core.beans.VendorInfo;
import org.munchub.core.dao.VendorDAO;
import org.munchub.core.entity.VendorEntity;

public class VendorServiceImpl implements VendorService{
	
	private VendorDAO vendorDAO;
	private VendorBeanConverter vendorBeanConvertor;
	
	public VendorDAO getVendorDAO() {
		return vendorDAO;
	}

	public void setVendorDAO(VendorDAO vendorDAO) {
		this.vendorDAO = vendorDAO;
	}

	public void setVendorBeanConvertor(VendorBeanConverter vendorBeanConvertor) {
		this.vendorBeanConvertor = vendorBeanConvertor;
	}

	@Override
	public Vendor addVendor(Vendor vendor) {
		VendorEntity vendorEntity = vendorBeanConvertor.toVendorEntity(vendor);
		long vendorId = vendorDAO.addVendor(vendorEntity);
		VendorEntity newVendorEntity = vendorDAO.getVendorById(vendorId);
		vendor = vendorBeanConvertor.toVendorBean(newVendorEntity);
		return vendor;
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVendor(long id) {
		
	}

	@Override
	public VendorInfo getVendorById(long id) {
		VendorEntity vendorEntity = vendorDAO.getVendorById(id);
		return vendorBeanConvertor.toVendorInfo(vendorEntity);		
	}

	@Override
	public List<VendorInfo> getVendors() {
		List<VendorInfo> lstVendor = null;
		List<VendorEntity> lstVendorEntity = vendorDAO.getVendors();
		if(lstVendorEntity != null && lstVendorEntity.size() > 0){
			lstVendor =  vendorBeanConvertor.convertVendorListToVendorInfo(lstVendorEntity);
		}
		return lstVendor;		
	}

	@Override
	public List<Vendor> getNearByVendor(long distance, long latitube,
			long longitude) {
		// TODO Auto-generated method stub
		return null;
	}

}
