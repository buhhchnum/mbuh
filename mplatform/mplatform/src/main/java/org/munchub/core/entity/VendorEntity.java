package org.munchub.core.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "MH_VENDOR")
public class VendorEntity extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "VENDOR_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_VENDOR")
    @SequenceGenerator(name = "gen_VENDOR", sequenceName = "MH_VENDOR_SQ")
	private Long id;
	
	@Column(name ="VENDOR_NAME")
	private String name;
	
	@Column(name =  "DESCRIPTION")
	private String description;
	
	@Column(name =  "EMAIL_ADDRESS")
	private String email;
	
	@Column(name =  "PASSWORD")
	private String password;
	
	@Column(name =  "PHONE_NUMBER")
	private String phoneNumber;
	
	@OneToOne
    @JoinColumn(name = "BUSINESS_TYPE", nullable = true)
	private BusinessTypeEntity businessType;
	
	/*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS")
	private AddressEntity address;*/
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(name="LATITUDE")
	private Long latitude;
	
	@Column(name="LONGITUDE")
	private Long longitude;
	
	@OneToMany
    @JoinColumn(name = "VENDOR_ID")
    @Cascade(value = {  org.hibernate.annotations.CascadeType.ALL,  org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
	private List<ItemEntity> items;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public BusinessTypeEntity getBusinessType() {
		return businessType;
	}
	public void setBusinessType(BusinessTypeEntity businessType) {
		this.businessType = businessType;
	}
	/*public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity address) {
		this.address = address;
	}	*/
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Long getLatitude() {
		return latitude;
	}
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	public Long getLongitude() {
		return longitude;
	}
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	public List<ItemEntity> getItems() {
		return items;
	}
	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}
	
	
}
