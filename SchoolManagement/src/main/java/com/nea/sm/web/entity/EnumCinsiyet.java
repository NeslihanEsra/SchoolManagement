package com.nea.sm.web.entity;

public enum EnumCinsiyet {
	KADIN("Kadın"),
	ERKEK("Erkek"),
	DIGER("Diger");
	
	private String cinsiyet;
	
	private EnumCinsiyet(String cinsiyet){
		this.cinsiyet = cinsiyet;
	}
	
	public String getCinsiyet() {
		return cinsiyet;
	}
	
}
