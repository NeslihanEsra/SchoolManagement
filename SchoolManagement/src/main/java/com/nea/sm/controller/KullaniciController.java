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
		System.out.println("Post Construct oluþturuldu");
		orderByIdByAsc();
		kullanici = new Kullanici();
	}
	
	public void kullaniciKaydet() {
		System.out.println("Kullanýcý kaydedildi");
		kullaniciRepository.save(kullanici);
		kullanici = new Kullanici();
		orderByIdByAsc();
	}
	
	public void kullaniciSil(Long id) {
		System.out.println("Kullanýcý silindi");
		Kullanici kullanici = kullaniciRepository.findOne(id);
		kullaniciRepository.delete(kullanici);
		orderByIdByAsc();
	}
	
	private void orderByIdByAsc() {
		kullaniciList=kullaniciRepository.findAllByOrderByIdAsc();
	}
		
	public void kullaniciyiGüncelle(Long id) {
		kullanici = kullaniciRepository.findOne(id);
	}
}
