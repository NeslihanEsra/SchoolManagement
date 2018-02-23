package com.nea.sm.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "kullanici")
@EqualsAndHashCode(callSuper = false)
@Data
public class Kullanici extends BaseEntity {
	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "seq_usr", allocationSize = 1, sequenceName = "seq_usr")
	@GeneratedValue(generator = "seq_usr", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "ad", length = 30)
	private String ad;

	@Column(name = "soyad", length = 30)
	private String soyad;

	@Column(name = "k_adi", length = 15, unique=true)
	private String kullaniciAdi;

	@Column(name = "k_sifre")
	private String sifre;
	
	@Column(name = "eposta", length = 15)
	private String eposta;
	
	@Column(name = "uyelik_tarihi")
	@Temporal(TemporalType.DATE)
	private Date uyelikTarihi;
	
	@Column(name = "tel", length=10)	
	private String tel;

	@Enumerated
	@Column(name = "rol")	
	private KullaniciRol rol;
	
	@Transient
	public String getAdSoyad(){
		return this.ad + " " + this.soyad;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Kullanici) {
			if (((Kullanici) obj).getId().equals(this.id)) {
				return true;
			}
		}
		return false;
	}
	
}  