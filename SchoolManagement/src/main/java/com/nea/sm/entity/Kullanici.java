package com.nea.sm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "kullanici")
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

	@Column(name = "k_adi", length = 15)
	private String kullaniciAdi;

	@Column(name = "k_sifre", length = 15)
	private String sifre;
	
	@Column(name = "eposta", length = 15)
	private String eposta;


}
