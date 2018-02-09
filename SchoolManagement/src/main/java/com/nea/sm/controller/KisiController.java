package com.nea.sm.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.nea.sm.entity.Kisi;
import com.nea.sm.repository.KisiRepository;

@Controller("kisiController")
@Scope("session")
public class KisiController {

	@Autowired
	private KisiRepository kisiRepository;
	
	private List<Kisi> kisiList;
	
	public List<Kisi> getKisiList() {
		return kisiList;
	}
	
	public void setKisiList(List<Kisi> kisiList) {
		this.kisiList = kisiList;
	}
	
	@PostConstruct
	private void init() {
		System.out.println("Post Construct oluþturuldu");
		kisiList = kisiRepository.findAll();
	}
}
