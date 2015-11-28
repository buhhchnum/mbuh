package org.munchub.core.beans;

import java.util.List;

public class VendorInfo {
	
	private Long id;
	private String name;
	private String email;
	private String description;
	private List<String> phoneNumber;
	private Address address;
	private String businessType;
	private List<ItemInfo> items;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public List<ItemInfo> getItems() {
		return items;
	}
	public void setItems(List<ItemInfo> items) {
		this.items = items;
	}
	
}
