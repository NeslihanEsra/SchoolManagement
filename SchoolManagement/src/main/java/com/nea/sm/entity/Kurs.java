package com.nea.sm.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Entity
@Table(name = "kurs")
@Data
public class Kurs {

	@Id
	@SequenceGenerator(name = "seq_kurs", allocationSize = 1, sequenceName = "seq_kurs")
    @GeneratedValue(generator = "seq_kurs", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "ad")
    private String ad;
	
	@Column(name = "baslama_tarihi")
	@Temporal(TemporalType.DATE)
    private Date baslamaTarihi;
	
	@Column(name = "fiyat")
    private BigDecimal fiyat; 
	
	
	 @Override
	    public boolean equals(Object obj) {
	    	if(obj instanceof Kurs){
	    		if(((Kurs)obj).getId().equals(this.id)){
	    			return true;
	    		}
	    	}
	    	return false;
	    }
}
