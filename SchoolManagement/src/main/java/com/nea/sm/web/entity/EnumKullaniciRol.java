package com.nea.sm.web.entity;

public enum EnumKullaniciRol {
	ADMIN("Y�netici"), 
	MUHASEBE("Muhasebe"), 
	OGRETMEN("��retmen"), 
	IK("�nsan Kaynaklar�"), 
	DEM�RBAS("Demirba�"), 
	USER("Kullan�c�");

	private String rolAd;

	private EnumKullaniciRol(String rolAd) {
		this.rolAd = rolAd;
	}

	public String getRolAd() {
		return rolAd;
	}

}
