package com.nea.sm.web.entity;

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
@Table(name = "kurs")
@Data
public class YonetimKurs {

	@Id
	@SequenceGenerator(name = "seq_kurs", allocationSize = 1, sequenceName = "seq_kurs")
	@GeneratedValue(generator = "seq_kurs", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "ad")
	private String ad;

	@Column(name = "fiyat")
	private BigDecimal fiyat;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof YonetimKurs) {
			if (((YonetimKurs) obj).getId().equals(this.id)) {
				return true;
			}
		}
		return false;
	}
}
