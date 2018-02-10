package com.nea.sm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "kullanici")
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

	@Column(name = "k_adi", length = 15)
	private String kullaniciAdi;

	@Column(name = "k_sifre", length = 15)
	private String sifre;
	
	@Column(name = "eposta", length = 15)
	private String eposta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
	public String getEposta() {
		return eposta;
	}
	
	public void setEposta(String eposta) {
		this.eposta = eposta;
	}

}
