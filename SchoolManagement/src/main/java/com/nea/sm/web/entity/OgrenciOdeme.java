package com.nea.sm.web.entity;

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

import lombok.Data;

@Entity
@Table(name = "ogrenci_odeme")
@Data
public class OgrenciOdeme {

	@Id
	@SequenceGenerator(name = "seq_ogrenci_odeme", allocationSize = 1, sequenceName = "seq_ogrenci_odeme")
	@GeneratedValue(generator = "seq_ogrenci_odeme", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "aciklama", length = 400)
	private String aciklama;

	@Column(name = "odeme_miktari", scale = 2, precision = 14)
	private BigDecimal odemeMiktari;

	@ManyToOne
	@JoinColumn(name = "ogrenci_id")
	private Ogrenci ogrenci;

	@Column(name = "odeme_tarihi")
	private Date odemeTarihi;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof OgrenciOdeme) {
			if (((OgrenciOdeme) obj).getId().equals(this.id)) {
				return true;
			}
		}
		return false;
	}
}
