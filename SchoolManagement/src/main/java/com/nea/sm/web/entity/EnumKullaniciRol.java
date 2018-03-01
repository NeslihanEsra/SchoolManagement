package com.nea.sm.web.entity;

public enum EnumKullaniciRol {
	ADMIN("Yönetici"), 
	MUHASEBE("Muhasebe"), 
	OGRETMEN("Öðretmen"), 
	IK("Ýnsan Kaynaklarý"), 
	DEMÝRBAS("Demirbaþ"), 
	USER("Kullanýcý");

	private String rolAd;

	private EnumKullaniciRol(String rolAd) {
		this.rolAd = rolAd;
	}

	public String getRolAd() {
		return rolAd;
	}

}
