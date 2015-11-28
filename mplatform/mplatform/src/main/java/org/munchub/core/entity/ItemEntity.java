package org.munchub.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "MH_ITEM")
public class ItemEntity extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "ITEM_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_ITEM")
    @SequenceGenerator(name = "gen_ITEM", sequenceName = "MH_ITEM_SQ")
	private Long id;
	
	@Column(name = "ITEM_NAME")
	private String name;
	
	@Column(name = "ICON_PATH")
	private String iconPath;
	
	@Column(name = "ORIGINAL_PRICE")
	private Double originalPrice;
	
	@Column(name = "DISCOUNTED_PRICE")
	private Double discountedPrice;
	
	@OneToOne
    @JoinColumn(name = "ITEM_TYPE", nullable = true)
	private ItemTypeEntity itemType;
	
	@Column(name ="OFFER_EXP_DATE")
	private Date offerExpiryDate;
	
	@ManyToOne()
    @JoinColumn(name="VENDOR_ID",nullable = false)
    @OnDelete(action=OnDeleteAction.NO_ACTION)
    private VendorEntity vendor;
	
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
	public String getIconPath() {
		return iconPath;
	}
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	public Double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public Double getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	public ItemTypeEntity getItemType() {
		return itemType;
	}
	public void setItemType(ItemTypeEntity itemType) {
		this.itemType = itemType;
	}
	public Date getOfferExpiryDate() {
		return offerExpiryDate;
	}
	public void setOfferExpiryDate(Date offerExpiryDate) {
		this.offerExpiryDate = offerExpiryDate;
	}
	public VendorEntity getVendor() {
		return vendor;
	}
	public void setVendor(VendorEntity vendor) {
		this.vendor = vendor;
	}
	
	
}
