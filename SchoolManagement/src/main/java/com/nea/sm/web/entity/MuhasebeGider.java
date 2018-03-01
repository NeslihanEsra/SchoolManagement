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
@Table(name = "gider")
@Data
public class MuhasebeGider {

	@Id
	@SequenceGenerator(name = "seq_gider", allocationSize = 1, sequenceName = "seq_gider")
	@GeneratedValue(generator = "seq_gider", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "konu", length = 100)
	private String konu;

	@Column(name = "miktar", precision = 14, scale = 2)
	private BigDecimal miktar;

	@Column(name = "tarih")
	private Date tarih;

	@ManyToOne
	@JoinColumn(name = "ogretmen_id")
	private IKOgretmen ogretmen;

	@ManyToOne
	@JoinColumn(name = "personel_id")
	private IKPersonel personel;

	@ManyToOne
	@JoinColumn(name = "envanter_id")
	private Envanter envanter;
}
