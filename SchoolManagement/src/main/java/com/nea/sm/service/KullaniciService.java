package com.nea.sm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nea.sm.entity.Kullanici;
import com.nea.sm.repository.KullaniciRepository;

@Service("kullaniciService")
public class KullaniciService {

	@Autowired
	private KullaniciRepository kullaniciRepository;

	public Kullanici save(Kullanici kullanici) {
		if (kullanici.getId() == null) {
			Md5PasswordEncoder encoder = new Md5PasswordEncoder();
			String md5Sifre = encoder.encodePassword(kullanici.getSifre(), null);
			kullanici.setSifre(md5Sifre);
		}
		return kullaniciRepository.save(kullanici);
	}
}
