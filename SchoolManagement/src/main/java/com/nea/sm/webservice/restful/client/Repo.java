package com.nea.sm.webservice.restful.client;

import java.io.Serializable;

import lombok.Data;

@Data
public class Repo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String full_name;
}
