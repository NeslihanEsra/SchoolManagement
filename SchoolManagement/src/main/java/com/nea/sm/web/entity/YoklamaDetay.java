package com.nea.sm.web.entity;

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
@Table(name = "yoklama_detay")
@Data
public class YoklamaDetay {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "seq_yklm", allocationSize = 1, sequenceName = "seq_yklm")
	@GeneratedValue(generator = "seq_yklm", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "yoklama_id")
	private Yoklama yoklama;

	@ManyToOne
	@JoinColumn(name = "ogrenci_id")
	private Ogrenci ogrenci;

	@Column(name = "geldi_mi")
	private Boolean geldiMi;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof YoklamaDetay) {
			if (((YoklamaDetay) obj).getId().equals(this.id)) {
				return true;
			}
		}
		return false;
	}
}
