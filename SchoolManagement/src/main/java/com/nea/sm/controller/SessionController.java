package com.nea.sm.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.nea.sm.entity.Kullanici;
import com.nea.sm.repository.KullaniciRepository;

@Controller("sessionController")
@Scope("session")
public class SessionController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private  KullaniciRepository kullaniciRepository;
	
	public Kullanici getUser() {
		String kullaniciAdi = SecurityContextHolder.getContext().getAuthentication().getName();
		return kullaniciRepository.getByKullaniciAdi(kullaniciAdi);
	}
}
