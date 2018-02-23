package com.nea.sm.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;

@Scope("session")
@Controller("loginController")
public class LoginController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	String username;

	@Getter @Setter
	String password;

	@PostConstruct
	public void init() {
		System.out.println("Login Controller init edildi");

	}
	
}
