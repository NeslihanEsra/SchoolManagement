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

import lombok.Data;

@Entity
@Table(name = "personel")
@Data
public class IKPersonel {

	@Id
	@SequenceGenerator(name = "seq_personel", allocationSize = 1, sequenceName = "seq_personel")
	@GeneratedValue(generator = "seq_personel", strategy = GenerationType.SEQUENCE)
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

	@Column(name = "baslama_tarihi")
	private Date baslamaTarihi;
}
