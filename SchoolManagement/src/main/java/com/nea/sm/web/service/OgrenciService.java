package com.nea.sm.web.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nea.sm.web.entity.Ogrenci;
import com.nea.sm.web.repository.OgrenciRepository;

@Service("ogrenciService")
public class OgrenciService {

	@Autowired
	private OgrenciRepository ogrenciRepository;
	
	public Ogrenci save(Ogrenci ogrenci) {
		ogrenci.setKayitTarihi(new Date());
		return ogrenciRepository.save(ogrenci);
	}
}
