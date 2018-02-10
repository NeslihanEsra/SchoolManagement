package com.nea.sm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

	@Column(name = "ekleyen", length = 20)
	private String ekleyen;

	@Column(name = "guncelleyen", length = 20)
	private String guncelleyen;

	@Column(name = "ekleme_tarihi")
	private Date eklemeTarihi;

	@Column(name = "guncelleme_tarihi")
	private Date guncellemeTarihi;

	@Column(name = "kayýt_durumu")
	private Boolean kayitDurumu;

	public String getEkleyen() {
		return ekleyen;
	}

	public void setEkleyen(String ekleyen) {
		this.ekleyen = ekleyen;
	}

	public String getGuncelleyen() {
		return guncelleyen;
	}

	public void setGuncelleyen(String guncelleyen) {
		this.guncelleyen = guncelleyen;
	}

	public Date getEklemeTarihi() {
		return eklemeTarihi;
	}

	public void setEklemeTarihi(Date eklemeTarihi) {
		this.eklemeTarihi = eklemeTarihi;
	}

	public Date getGuncellemeTarihi() {
		return guncellemeTarihi;
	}

	public void setGuncellemeTarihi(Date guncellemeTarihi) {
		this.guncellemeTarihi = guncellemeTarihi;
	}

	public Boolean getKayitDurumu() {
		return kayitDurumu;
	}

	public void setKayitDurumu(Boolean kayitDurumu) {
		this.kayitDurumu = kayitDurumu;
	}

	

	

}
