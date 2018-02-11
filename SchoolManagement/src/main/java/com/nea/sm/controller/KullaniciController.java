package com.nea.sm.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.nea.sm.entity.Kullanici;
import com.nea.sm.repository.KullaniciRepository;

import lombok.Getter;
import lombok.Setter;

@Controller("kullaniciController")
@Scope("session")
public class KullaniciController {

	@Autowired
	private KullaniciRepository kullaniciRepository;
	
	@Getter @Setter
	private List<Kullanici> kullaniciList;
	
	@Getter @Setter
	private Kullanici kullanici;
	
	@PostConstruct
	private void init() {
		System.out.println("Post Construct olu�turuldu");
		orderByIdByAsc();
		kullanici = new Kullanici();
	}
	
	public void kullaniciKaydet() {
		System.out.println("Kullan�c� kaydedildi");
		kullaniciRepository.save(kullanici);
		kullanici = new Kullanici();
		orderByIdByAsc();
	}
	
	public void kullaniciSil(Long id) {
		System.out.println("Kullan�c� silindi");
		Kullanici kullanici = kullaniciRepository.findOne(id);
		kullaniciRepository.delete(kullanici);
		orderByIdByAsc();
	}
	
	private void orderByIdByAsc() {
		kullaniciList=kullaniciRepository.findAllByOrderByIdAsc();
	}
		
	public void kullaniciyiG�ncelle(Long id) {
		kullanici = kullaniciRepository.findOne(id);
	}
}
