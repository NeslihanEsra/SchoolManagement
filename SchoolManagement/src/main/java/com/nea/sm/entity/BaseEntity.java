package com.nea.sm.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

	private Date eklemeTarihi;
	private String ekleyen;
	private Date guncellemeTarihi;
	private String guncelleyen;
	
}
