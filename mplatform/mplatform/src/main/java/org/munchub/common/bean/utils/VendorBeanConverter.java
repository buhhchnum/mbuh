package org.munchub.common.bean.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.munchub.commons.utils.CollectionUtil;
import org.munchub.core.beans.Address;
import org.munchub.core.beans.BusinessType;
import org.munchub.core.beans.Vendor;
import org.munchub.core.beans.VendorInfo;
import org.munchub.core.dao.VendorDAO;
import org.munchub.core.entity.BusinessTypeEntity;
import org.munchub.core.entity.VendorEntity;


public class VendorBeanConverter {

	private VendorDAO vendorDAO;

	public void setVendorDAO(VendorDAO vendorDAO) {
		this.vendorDAO = vendorDAO;
	}

	public VendorEntity toVendorEntity(Vendor vendor){
		VendorEntity vendorEntity = null;
		if(vendor != null){
			vendorEntity = new VendorEntity();
			vendorEntity.setName(vendor.getName());
			vendorEntity.setPassword(vendor.getPassword());
			vendorEntity.setEmail(vendor.getEmail());
			vendorEntity.setDescription(vendor.getDescription());

			Address address = vendor.getAddress();
			vendorEntity.setStreet(address.getStreet());
			vendorEntity.setCity(address.getCity());
			vendorEntity.setState(address.getState());
			vendorEntity.setCountry(address.getCountry());
			vendorEntity.setPostalCode(address.getPostalCode());
			vendorEntity.setLatitude(address.getLatitude());
			vendorEntity.setLongitude(address.getLongitude());

			StringBuilder sbPhone = new StringBuilder();
			List<String> lstPhoneNumbers = vendor.getPhoneNumber();			
			if(!CollectionUtil.isEmpty(lstPhoneNumbers)){
				for (int i=0; i<lstPhoneNumbers.size(); i++) {
					if(i > 0){
						sbPhone.append(",");
					}
					sbPhone.append(lstPhoneNumbers.get(i));
				}				
			}

			vendorEntity.setPhoneNumber(sbPhone.toString());
			BusinessTypeEntity bTypeEntity = vendorDAO.getBusinessType(vendor.getBusinessType().getId());
			vendorEntity.setBusinessType(bTypeEntity);
		}
		return vendorEntity;
	}

	public Vendor toVendorBean(VendorEntity vendorEntity){

		Vendor vendor = new Vendor();
		vendor.setId(vendorEntity.getId());
		vendor.setName(vendorEntity.getName());
		vendor.setEmail(vendorEntity.getEmail());
		vendor.setBusinessType(toBusinessType(vendorEntity.getBusinessType()));
		vendor.setDescription(vendorEntity.getDescription());

		Address address = new Address();		
		address.setStreet(vendorEntity.getStreet());
		address.setCity(vendorEntity.getCity());
		address.setState(vendorEntity.getState());
		address.setCountry(vendorEntity.getCountry());
		address.setPostalCode(vendorEntity.getPostalCode());
		address.setLatitude(vendorEntity.getLatitude());
		address.setLongitude(vendorEntity.getLongitude());
		vendor.setAddress(address);

		List<String> lstPhoneNumber = new ArrayList<String>();
		String phoneNumbers = vendorEntity.getPhoneNumber();

		StringTokenizer st = new StringTokenizer(phoneNumbers, ",");
		while(st.hasMoreTokens()){
			lstPhoneNumber.add(st.nextToken());
		}
		vendor.setPhoneNumber(lstPhoneNumber);		

		ItemBeanConverter itemConverter = new ItemBeanConverter();
		vendor.setItems(itemConverter.toItems(vendorEntity.getItems()));

		return vendor;	
	}

	public List<Vendor> toVendorList(List<VendorEntity> lstVendorEntity){
		List<Vendor> lstVendor = new ArrayList<Vendor>();

		for (VendorEntity vendorEntity : lstVendorEntity) {
			lstVendor.add(toVendorBean(vendorEntity));
		}

		return lstVendor;
	}

	private BusinessType toBusinessType(BusinessTypeEntity entity){
		BusinessType businessType = new BusinessType();
		businessType.setId(entity.getId());
		businessType.setName(entity.getType());
		return businessType;
	}

	public List<VendorInfo> convertVendorListToVendorInfo(List<VendorEntity> lstVendorEntity){
		List<VendorInfo> lstVendor = new ArrayList<VendorInfo>();

		for (VendorEntity vendorEntity : lstVendorEntity) {
			lstVendor.add(toVendorInfo(vendorEntity));
		}
		return lstVendor;
	}

	public VendorInfo toVendorInfo(VendorEntity vendorEntity){		
		VendorInfo vendor = new VendorInfo();
		vendor.setId(vendorEntity.getId());
		vendor.setName(vendorEntity.getName());
		vendor.setEmail(vendorEntity.getEmail());
		vendor.setBusinessType(vendorEntity.getBusinessType().getType());
		vendor.setDescription(vendorEntity.getDescription());
		Address address = new Address();		
		address.setStreet(vendorEntity.getStreet());
		address.setCity(vendorEntity.getCity());
		address.setState(vendorEntity.getState());
		address.setCountry(vendorEntity.getCountry());
		address.setPostalCode(vendorEntity.getPostalCode());
		address.setLatitude(vendorEntity.getLatitude());
		address.setLongitude(vendorEntity.getLongitude());
		vendor.setAddress(address);

		List<String> lstPhoneNumber = new ArrayList<String>();
		String phoneNumbers = vendorEntity.getPhoneNumber();

		StringTokenizer st = new StringTokenizer(phoneNumbers, ",");
		while(st.hasMoreTokens()){
			lstPhoneNumber.add(st.nextToken());
		}
		vendor.setPhoneNumber(lstPhoneNumber);		

		ItemBeanConverter itemConverter = new ItemBeanConverter();
		vendor.setItems(itemConverter.convertItemEntityListToSiteInfo(vendorEntity.getItems()));

		return vendor;	

	}
}
