package org.munchub.core.service;

import java.util.List;

import org.munchub.core.beans.Vendor;
import org.munchub.core.beans.VendorInfo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
public interface VendorService {
	
	public Vendor addVendor(Vendor vendor);
	public Vendor updateVendor(Vendor vendor);
	public void deleteVendor(long id);
	public VendorInfo getVendorById(long id);
	// TODO Change it to Vendor Info to send minimal data.
	public List<VendorInfo> getVendors();
	//TODO Change it to Vendor Info to send minimal data.
	public List<Vendor> getNearByVendor(long distance, long latitube, long longitude);
}
