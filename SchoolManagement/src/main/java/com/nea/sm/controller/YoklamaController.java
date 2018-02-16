package com.nea.sm.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.nea.sm.entity.Grup;
import com.nea.sm.entity.Yoklama;
import com.nea.sm.repository.GrupRespository;

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
	private GrupRespository grupRespository;
	
	@Getter @Setter
	private List<Grup> grupList;
	
	@Getter @Setter
	private Yoklama yoklama;
	
	@Getter @Setter
	private boolean yoklamaFormuGorunsun = false;
	
	@PostConstruct
	public void init() {
		grupList = grupRespository.findAll();
		yoklama = new Yoklama();
	}
	
	public void calendarChange() {
		System.out.println("yoklama formu göründü");
		yoklamaFormuGorunsun = true;
	}
	
	
}
