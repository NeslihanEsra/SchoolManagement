package com.nea.sm.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.nea.sm.webservice.restful.client.GithubConfig;
import com.nea.sm.webservice.restful.client.Repo;
import com.nea.sm.webservice.restful.client.User;

import lombok.Getter;
import lombok.Setter;

@Controller("retroController")
@Scope("session")
public class RetroController {

	@Autowired
	private GithubConfig githubConfig;

	@Getter
	private User user;

	@Getter
	private List<Repo> repos;

	@Getter
	@Setter
	private String username;

	@PostConstruct
	private void init() {
	}

	public void kulaniciGetir() {
		try {
			user = githubConfig.getUser(username);
			repos  = githubConfig.getRepo(username);
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
