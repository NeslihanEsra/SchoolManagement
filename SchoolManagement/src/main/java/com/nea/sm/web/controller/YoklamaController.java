package com.nea.sm.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.nea.sm.web.entity.YonetimGrup;
import com.nea.sm.web.entity.IKOgretmen;
import com.nea.sm.web.entity.Ogrenci;
import com.nea.sm.web.entity.OgrenciGrup;
import com.nea.sm.web.entity.Yoklama;
import com.nea.sm.web.entity.YoklamaDetay;
import com.nea.sm.web.repository.GrupRespository;
import com.nea.sm.web.repository.OgrenciGrupRepository;
import com.nea.sm.web.repository.OgrenciRepository;
import com.nea.sm.web.repository.YoklamaDetayRepository;
import com.nea.sm.web.repository.YoklamaRepository;

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
	private Yoklama yoklama;

	@Getter 
	private List<YonetimGrup> grupList;
	
	@Getter 
	private List<OgrenciGrup> ogrenciGrupList;
	
	@Getter @Setter
	private List<String> gelenOgrencilerList;
	
	@Getter @Setter
	private List<Yoklama> yoklamaList;
	
	@Getter @Setter
	private List<Yoklama> oncekiYoklamaList;
		
	
	@PostConstruct
	public void init() {
		grupList = grupRespository.findAll();
		yoklama = new Yoklama();
	}
	
	public void yoklamaGetir() {
		ogrenciGrupList = ogrenciGrupRepository.getGrupById(yoklama.getGrup().getId());
		//ogrenciGrupList = ogrenciGrupRepository.findAll();
		System.out.println("grup ogrencileri listelendi");
	}
	
//	public void grupIdGetir(Long id) {
//		ogrenciGrupList = ogrenciGrupRepository.findById(yoklama.getGrup().getId());
//	}

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
	
	public List<Yoklama> oncekiYoklamariListele() {
		System.out.println("önceki yoklamalar listeleniyor");
		if(yoklama.getGrup().getId() !=null && !yoklama.getGrup().getId().equals("")){
			oncekiYoklamaList = yoklamaRepository.getByGrupId(yoklama.getGrup().getId());
			return oncekiYoklamaList;
		}
		return null;
	}	

}