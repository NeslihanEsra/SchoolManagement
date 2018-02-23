package com.nea.sm.webservice.restful.client;

import java.io.Serializable;
import java.util.Date;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String login;
	private Long id;
	private String avatar_url;
	private String gravatar_id;
	private String url;
	private String html_url;
	private String followers_url;
	private String following_url;
	private String gists_url;
	private String type;
	private Boolean site_admin;
	private String name;
	private String company;
	private String blog;
	private String location;
	private String email;
	private Boolean hireable;
	private String bio;
	private Integer public_repos;
	private Integer public_gists;
	private Integer followers;
	private Integer following;
	private Date created_at;
	private Date updated_at;
	
	
}
