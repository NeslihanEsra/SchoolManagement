package com.nea.sm.web.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "gun")
@Data
public class YonetimGun {
	@Id
	@SequenceGenerator(name = "seq_gun", allocationSize = 1, sequenceName = "seq_gun")
	@GeneratedValue(generator = "seq_gun", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "gun1")
	private int gun1;
	
	@Column(name = "gun2")
	private int gun2;
	
	@Column(name = "gun3")
	private int gun3;
	
	@Column(name = "gun4")
	private int gun4;
	
	@Column(name = "gun5")
	private int gun5;
	
	@Column(name = "gun6")
	private int gun6;
	
	@Column(name = "gun7")
	private int gun7;
}
