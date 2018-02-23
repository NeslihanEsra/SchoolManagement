package com.nea.sm.webservice.restful.client;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
@ApplicationScope
public class GithubConfig {

	public static final String API_URL = "https://api.github.com";
	
	private GithubOperations githubOperations;
	
	@PostConstruct
	private void init() {
		createClient();
	}
	
	private void createClient() {
		Retrofit retrofit = new Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create())
				.baseUrl(API_URL)
				.build();
		githubOperations = retrofit.create(GithubOperations.class);
	}
	
	public User getUser(String username) throws Exception{
		return githubOperations.getUserByName(username).execute().body();
	}
	
	public List<Repo> getRepo(String username) throws Exception {
		return githubOperations.getReposByUsername(username).execute().body();
	}
	
	
}
