package org.munchub.core.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.munchub.core.beans.Vendor;
import org.munchub.core.beans.VendorInfo;
import org.munchub.core.service.VendorService;
import org.springframework.stereotype.Component;

@Component
@Path("/vendors")
public class VendorResource {
	
	private VendorService vendorService;
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<VendorInfo> getAllVendors(){
		return vendorService.getVendors();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createVendor(Vendor vendor){
		vendor = vendorService.addVendor(vendor);		
	}
	
	@GET
	@Path("/{vendorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public VendorInfo getVendorById(@PathParam("vendorId") Long id)
    {
		return vendorService.getVendorById(id);
    }

	public void setVendorService(VendorService vendorService) {
		this.vendorService = vendorService;
	}	
}
