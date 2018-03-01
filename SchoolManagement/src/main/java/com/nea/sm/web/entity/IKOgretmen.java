package com.nea.sm.web.entity;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ogretmen")
@Data
public class IKOgretmen {

	@Id
	@SequenceGenerator(name = "seq_ogretmen", allocationSize = 1, sequenceName = "seq_ogretmen")
	@GeneratedValue(generator = "seq_ogretmen", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "ad", length = 50)
	private String ad;

	@Column(name = "soyad", length = 50)
	private String soyad;

	@Column(name = "adres", length = 500)
	private String adres;

	@Column(name = "tel", length = 13)
	private String tel;

	@Column(name = "eposta", length = 100)
	private String eposta;

	@Column(name = "ucret", precision = 14, scale = 2)
	private BigDecimal ucret;

	@Column(name = "kayýt_tarihi")
	private Date kayýtTarihi;

	@Transient
	public String getAdSoyad() {
		return this.ad + " " + this.soyad;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IKOgretmen) {
			if (((IKOgretmen) obj).getId().equals(this.id)) {
				return true;
			}
		}
		return false;
	}
}
