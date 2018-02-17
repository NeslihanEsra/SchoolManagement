package com.nea.sm.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.nea.sm.entity.Grup;
import com.nea.sm.entity.Ogrenci;
import com.nea.sm.entity.OgrenciGrup;
import com.nea.sm.entity.Yoklama;
import com.nea.sm.entity.YoklamaDetay;
import com.nea.sm.repository.GrupRespository;
import com.nea.sm.repository.OgrenciGrupRepository;
import com.nea.sm.repository.YoklamaDetayRepository;
import com.nea.sm.repository.YoklamaRepository;

import lombok.Getter;
import lombok.Setter;

@Scope("session")
@Controller("yoklamaController")
public class YoklamaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private YoklamaRepository yoklamaRepository;
	
	@Autowired
	private YoklamaDetayRepository yoklamaDetayRepository;
	
	@Autowired
	private GrupRespository grupRespository;
	
	@Autowired
	private OgrenciGrupRepository ogrenciGrupRepository;
	
	@Getter @Setter
	private List<Grup> grupList;
	
	@Getter @Setter
	private Yoklama yoklama;
	
	@Getter @Setter
	private YoklamaDetay yoklamaDetay;
	
	@Getter @Setter
	private List<OgrenciGrup> ogrenciGrupList;
	
	@Getter @Setter
	private List<String> gelenOgrencilerList;
		
	@PostConstruct
	public void init() {
		grupList = grupRespository.findAll();
		yoklama = new Yoklama();
		yoklamaDetay = new YoklamaDetay();
	}
	
	public void yoklamaGetir() {
		System.out.println("yoklama formu göründü");
		ogrenciGrupList = ogrenciGrupRepository.getGrupById(yoklama.getGrup().getId());
	}
	
	//önce yoklama tablosunu sonra yoklamaDetay tablosu kaydedilir
	public void yoklamaKaydet() {
		yoklama = yoklamaRepository.save(yoklama);
		for (int i = 0; i < gelenOgrencilerList.size(); i++) {
			YoklamaDetay yoklamaDetay = new YoklamaDetay();
			yoklamaDetay.setYoklama(yoklama);
			
			Ogrenci ogrenci = new Ogrenci();
			ogrenci.setId(Long.parseLong(gelenOgrencilerList.get(i)));
			yoklamaDetay.setOgrenci(ogrenci);

			yoklamaDetay.setGeldiMi(Boolean.TRUE);
			yoklamaDetayRepository.save(yoklamaDetay);
		}
		ogrenciGrupList = null;
		yoklama = new Yoklama();
		grupList = grupRespository.findAll();
	}
	
	public List<Yoklama> yoklamaListesiniGetir() {
		List<Yoklama> liste = yoklamaRepository.getByGrupId(yoklama.getGrup().getId());
		return liste;
	}
	
	
}
