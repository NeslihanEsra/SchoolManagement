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
@Table(name = "gelir")
@Data
public class MuhasebeGelir {

	@Id
	@SequenceGenerator(name = "seq_gelir", allocationSize = 1, sequenceName = "seq_gelir")
	@GeneratedValue(generator = "seq_gelir", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "konu", length = 100, nullable = false)
	private String konu;

	@Column(name = "miktar", precision = 14, scale = 2)
	private BigDecimal miktar;

	@Column(name = "tarih")
	private Date tarih;

	@ManyToOne
	@JoinColumn(name = "ogrenci_odeme_id")
	private OgrenciOdeme ogrenciOdeme;

	@ManyToOne
	@JoinColumn(name = "envanter_id")
	private Envanter envanter;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MuhasebeGelir) {
			if (((MuhasebeGelir) obj).getId().equals(this.id)) {
				return true;
			}
		}
		return false;
	}
}
