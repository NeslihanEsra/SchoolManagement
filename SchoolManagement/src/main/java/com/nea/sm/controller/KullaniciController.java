package com.nea.sm.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.nea.sm.entity.Kullanici;
import com.nea.sm.repository.KullaniciRepository;

@Controller("kullaniciController")
@Scope("session")
public class KullaniciController {

	@Autowired
	private KullaniciRepository kullaniciRepository;
	
	private List<Kullanici> kullaniciList;
	
	private Kullanici kullanici;
	
	@PostConstruct
	private void init() {
		System.out.println("Post Construct oluþturuldu");
		kullaniciList = kullaniciRepository.findAll();
		kullanici = new Kullanici();
	}
	
	public void kullaniciKaydet() {
		System.out.println("Kullanýcý kaydedildi");
		kullaniciRepository.save(kullanici);
		kullanici = new Kullanici();
		kullaniciList=kullaniciRepository.findAll();
	}
	
	public void kullaniciSil(Long id) {
		System.out.println("Kullanýcý silindi");
		Kullanici kullanici = kullaniciRepository.findOne(id);
		kullaniciRepository.delete(kullanici);
		kullaniciList=kullaniciRepository.findAll();
	}
		
	
	// getter and setter
	
	public List<Kullanici> getKullaniciList() {
		return kullaniciList;
	}
	
	public void setKullaniciList(List<Kullanici> kullaniciList) {
		this.kullaniciList = kullaniciList;
	}
	
	public Kullanici getKullanici() {
		return kullanici;
	}
	
	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}
}
