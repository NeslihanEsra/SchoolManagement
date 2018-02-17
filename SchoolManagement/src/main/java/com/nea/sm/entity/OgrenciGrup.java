package com.nea.sm.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="ogrenci_grup")
@Data
public class OgrenciGrup {
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "seq_yklm", allocationSize = 1, sequenceName = "seq_yklm")
	@GeneratedValue(generator = "seq_yklm", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ogrenci_id")
	private Ogrenci ogrenci;
	
	@ManyToOne
	@JoinColumn(name = "grup_id")
	private Grup grup;
	
	@Column(name="ucret")
	private BigDecimal ucret;
	
	@Column(name="kayýt_tarihi")
	@Temporal(TemporalType.DATE)
	private Date kayýtTarihi;
	
	
	@Override
    public boolean equals(Object obj) {
    	if(obj instanceof OgrenciGrup){
    		if(((OgrenciGrup)obj).getId().equals(this.id)){
    			return true;
    		}
    	}
    	return false;
    }
	
	

}
