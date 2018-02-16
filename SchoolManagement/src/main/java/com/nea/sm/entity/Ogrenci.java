package com.nea.sm.entity;

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

import lombok.Data;

@Entity
@Table(name="ogrenci")
@Data
public class Ogrenci {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "seq_ogrnc", allocationSize = 1, sequenceName = "seq_ogrnc")
	@GeneratedValue(generator = "seq_ogrnc", strategy = GenerationType.SEQUENCE)
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
	private Date kayitTarihi;
	
	@Enumerated
	@Column(name="cinsiyet")
	private EnumCinsiyet cinsiyet;
}
