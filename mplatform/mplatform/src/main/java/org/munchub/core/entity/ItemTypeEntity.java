package org.munchub.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MH_ITEM_TYPE")
public class ItemTypeEntity {
	
	@Id
    @Column(name = "ITEM_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_ITEM_TYPE")
    @SequenceGenerator(name = "gen_ITEM_TYPE", sequenceName = "MH_ITEM_TYP_SQ")
	private Long id;
	
	@Column(name = "ITEM_TYPE",  nullable=false)
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
