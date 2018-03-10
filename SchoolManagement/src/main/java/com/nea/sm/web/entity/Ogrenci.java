package com.nea.sm.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name="ogrenci")
@Data
public class Ogrenci {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "seq_ogr", allocationSize = 1, sequenceName = "seq_ogr")
	@GeneratedValue(generator = "seq_ogr", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="ad")
	private String ad;

	@Column(name="soyad")
	private String soyad;
	
	@Column(name="adres")
	private String adres;
	
	@Column(name="tel")
	private String tel;
	
	@Column(name="eposta")
	private String eposta;
	
	@Column(name="kayit_tarihi")
	@Temporal(TemporalType.DATE)
	private Date kayitTarihi;
	
	@Enumerated(EnumType.STRING)
	@Column(name="cinsiyet")
	private EnumCinsiyet cinsiyet;
	
	@Transient
	public String getAdSoyad(){
		return this.ad + " " + this.soyad;
	}
	
	@Override
    public boolean equals(Object obj) {
    	if(obj instanceof Ogrenci){
    		if(((Ogrenci)obj).getId().equals(this.id)){
    			return true;
    		}
    	}
    	return false;
    }
	
}
