package org.munchub.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MH_BUSINESS_TYPE")
public class BusinessTypeEntity {
	
	@Id
    @Column(name = "BUSINESS_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_BUSINESS_TYPE")
    @SequenceGenerator(name = "gen_BUSINESS_TYPE", sequenceName = "MH_BUSINESS_TYP_SQ")
	private Long id;
	
	@Column(name="BUSINESS_TYPE", nullable=false)
	private String type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
