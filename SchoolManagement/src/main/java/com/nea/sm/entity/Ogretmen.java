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
@Table(name = "ogretmen")
@Data
public class Ogretmen {

	@Id
	@SequenceGenerator(name = "seq_ogretmen", allocationSize = 1, sequenceName = "seq_ogretmen")
    @GeneratedValue(generator = "seq_ogretmen", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "ad")
    private String ad;

	@Column(name = "soyad")
	private String soyad;
	
	@Column(name = "adres")
    private String adres;
	
	@Column(name = "tel")
    private String tel;
	
	@Column(name = "eposta")
    private String eposta;

	@Column(name = "maas")
	private BigDecimal maas;
	
	@Column(name = "kayit_tarihi")
	@Temporal(TemporalType.DATE)
    private Date kayitTarihi;
	
	 @Override
	    public boolean equals(Object obj) {
	    	if(obj instanceof Ogretmen){
	    		if(((Ogretmen)obj).getId().equals(this.id)){
	    			return true;
	    		}
	    	}
	    	return false;
	    }
}
