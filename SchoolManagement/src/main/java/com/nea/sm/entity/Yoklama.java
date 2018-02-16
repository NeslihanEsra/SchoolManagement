package com.nea.sm.entity;

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
@Table(name="yoklama")
@Data
public class Yoklama {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "seq_yklm", allocationSize = 1, sequenceName = "seq_yklm")
	@GeneratedValue(generator = "seq_yklm", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "grup_id")
	private Grup grup;
	
	@Column(name="yoklama_aciklama")
	private String yoklamaAciklama;
	
	@Column(name="islenen_konu")
	private String islenenKonu;
	
	@Column(name="yoklama_tarihi")
	private Date yoklamaTarihi;
}
