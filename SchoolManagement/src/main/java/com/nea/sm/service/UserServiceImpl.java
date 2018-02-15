package com.nea.sm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nea.sm.entity.Kullanici;
import com.nea.sm.repository.KullaniciRepository;

@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	private KullaniciRepository kullaniciRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Kullanici kullanici = kullaniciRepository.getByKullaniciAdi(username);
		List<GrantedAuthorityImpl> authorities = new ArrayList<>();
		GrantedAuthorityImpl authority = new GrantedAuthorityImpl("USER");
		authorities.add(authority);
		User user = new User(kullanici.getAd(), kullanici.getSifre(),true, true, true, true, authorities);
		return user;
	}

	
}
