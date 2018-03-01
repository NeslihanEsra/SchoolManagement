package com.nea.sm.web.entity;

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
@Table(name = "grup_gun")
@Data
public class YonetimGrupGun {

	@Id
    @SequenceGenerator(name = "seq_grup_gun", allocationSize = 1, sequenceName = "seq_grup_gun")
    @GeneratedValue(generator = "seq_grup_gun", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "grup_id")
    private YonetimGrup grup;
	
	@ManyToOne
    @JoinColumn(name = "gun_id")
    private YonetimGun gun;
}
