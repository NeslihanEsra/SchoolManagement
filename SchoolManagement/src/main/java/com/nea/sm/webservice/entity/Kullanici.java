package com.nea.sm.webservice.entity;

import java.util.Date;

import lombok.Data;


@Data
public class Kullanici {
	private Long id;
	private String ad;
	private String soyad;
	private String kullaniciAdi;
	private String eposta;
	private Date uyelikTarihi;
}  
