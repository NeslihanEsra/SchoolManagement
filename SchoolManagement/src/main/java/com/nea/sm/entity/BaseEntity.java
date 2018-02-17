package com.nea.sm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
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


}
