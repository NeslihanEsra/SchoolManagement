package com.nea.sm.web.entity;

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
@Table(name = "demirbas")
@Data
public class EnvanterDemirbas {
	@Id
    @SequenceGenerator(name = "seq_demirbas", allocationSize = 1, sequenceName = "seq_demirbas")
    @GeneratedValue(generator = "seq_demirbas", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "aciklama", length = 400)
    private String aciklama;
	
	@Column(name = "tarih")
    private Date tarih;
	
	@ManyToOne
    @JoinColumn(name = "envanter_id")
    private Envanter envanter;
	
	@ManyToOne
    @JoinColumn(name = "personel_id")
    private IKPersonel personel;
	
	@ManyToOne
    @JoinColumn(name = "ogretmen_id")
    private IKOgretmen ogretmen;
}
