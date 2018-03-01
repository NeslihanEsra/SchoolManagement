package com.nea.sm.web.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nea.sm.web.entity.Kullanici;
import com.nea.sm.web.entity.EnumKullaniciRol;
import com.nea.sm.web.repository.KullaniciRepository;

@Service("kullaniciService")
public class KullaniciService {

	@Autowired
	private KullaniciRepository kullaniciRepository;
	
	@PostConstruct
	public void init() {
		long tomplamKayýt = kullaniciRepository.count();
		if (tomplamKayýt<1) {
			Kullanici kullanici = new Kullanici();
			kullanici.setAd("Neslihan");
			kullanici.setSoyad("Altýnýþýk");
			kullanici.setKullaniciAdi("nea");
			kullanici.setSifre("nea");
			kullanici.setEklemeTarihi(new Date());
			kullanici.setEposta("nea@nea.com.tr");
			kullanici.setKayitDurumu(Boolean.TRUE);
			kullanici.setRol(EnumKullaniciRol.ADMIN);
			kullanici.setTel("1234567891");
			kullanici.setUyelikTarihi(new Date());
			save(kullanici);
			System.out.println("kullanýcý adý:nea sifre:nea olan kayýt oluþturuldu");
		}
	}

	public Kullanici save(Kullanici kullanici) {
		if (kullanici.getId() == null) {
			Md5PasswordEncoder encoder = new Md5PasswordEncoder();
			String md5Sifre = encoder.encodePassword(kullanici.getSifre(), null);
			kullanici.setSifre(md5Sifre);
		}
		return kullaniciRepository.save(kullanici);
	}
}
