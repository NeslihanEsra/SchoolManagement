package com.nea.sm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "salon")
@Data
public class Salon {
	@Id
	@SequenceGenerator(name = "seq_salon", allocationSize = 1, sequenceName = "seq_salon")
    @GeneratedValue(generator = "seq_salon", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "ad")
    private String ad;
	
	@Column(name = "kod")
    private String kod;
    
	@Column(name = "kapasite")
	private int kapasite;
	
	
	@Override
    public boolean equals(Object obj) {
    	if(obj instanceof Salon){
    		if(((Salon)obj).getId().equals(this.id)){
    			return true;
    		}
    	}
    	return false;
    }

}
