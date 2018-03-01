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
@Table(name = "envanter")
@Data
public class Envanter {
	@Id
    @SequenceGenerator(name = "seq_envanter", allocationSize = 1, sequenceName = "seq_envanter")
    @GeneratedValue(generator = "seq_envanter", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "tanim", length = 100)
    private String tanim;
	
	@Column(name = "aciklama", length = 400)
    private String aciklama;
	
	@Column(name = "garanti")
    private Boolean garanti;
	
	@Column(name = "garanti_baslama_tarihi")
    private Date garantiBaslamaTarihi;
	
	@Column(name = "garanti_bitis_tarihi")
    private Date garantiBitisTarihi;
	
	@ManyToOne
    @JoinColumn(name = "gider_id")
    private MuhasebeGider gider;
}
