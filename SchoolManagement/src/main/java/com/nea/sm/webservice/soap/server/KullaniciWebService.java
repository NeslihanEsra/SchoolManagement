package com.nea.sm.webservice.soap.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nea.sm.web.repository.KullaniciRepository;
import com.nea.sm.webservice.entity.Kullanici;

@WebService(name="KullaniciWs", serviceName="KullaniciWs")
@Service
public class KullaniciWebService {

	@Autowired
	KullaniciRepository kullaniciRepository;
	
	@WebMethod(operationName="getByUsername")
	public Kullanici getByUsername(@WebParam(name="wsUsername") String wsUsername,
								   @WebParam(name="wsPassword") String wsPassword,
								   @WebParam(name="username") String username) {
		
		if (wsPassword.equals("1") && wsUsername.equals("1")) {
			
			com.nea.sm.web.entity.Kullanici kullanici = kullaniciRepository.getByKullaniciAdi(username);
			Kullanici kullaniciRequest = new Kullanici();
			kullaniciRequest.setId(kullanici.getId());
			kullaniciRequest.setAd(kullanici.getAd());
			kullaniciRequest.setSoyad(kullanici.getSoyad());
			kullaniciRequest.setKullaniciAdi(kullanici.getKullaniciAdi());
			kullaniciRequest.setUyelikTarihi(kullanici.getUyelikTarihi());
			
			return kullaniciRequest;
		}
		
		throw new UsernameNotFoundException(wsUsername + " bulunamadý");
		
	}
}
