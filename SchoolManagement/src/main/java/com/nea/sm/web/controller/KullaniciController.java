package com.nea.sm.web.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import com.nea.sm.web.entity.EnumKullaniciRol;
import com.nea.sm.web.entity.Kullanici;
import com.nea.sm.web.repository.KullaniciRepository;
import com.nea.sm.web.service.KullaniciService;

import lombok.Getter;
import lombok.Setter;

@Controller("kullaniciController")
@Scope("session")
public class KullaniciController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private KullaniciRepository kullaniciRepository;
	
	@Autowired
	private KullaniciService kullaniciService;
	
	@Getter @Setter
	private List<Kullanici> kullaniciList;
	
	@Getter @Setter
	private LazyDataModel<Kullanici> lazyDataModel;
	
	@Getter @Setter
	private Kullanici kullanici;
	
	@Setter
	private EnumKullaniciRol rol;
	
	@PostConstruct
	private void init() {
		s�rala();
		kullanici = new Kullanici();
	}
	
	public void kullaniciKaydet() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			System.out.println("Kullan�c� kaydedildi");
			kullaniciService.save(kullanici);
			s�rala();
	        context.addMessage(null, new FacesMessage("BA�ARILI",  "Kay�t Eklendi") );
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA",  "Kay�t Eklenemedi") );
		}
        kullanici = new Kullanici();
	}
	
	public void kullaniciSil(Long id) {
		System.out.println("Kullan�c� silindi");
		Kullanici kullanici = kullaniciRepository.findOne(id);
		kullaniciRepository.delete(kullanici);
		s�rala();
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("BA�ARILI",  "Kay�t Silindi") );
	}
	
	public void kullaniciyiG�ncelle(Long id) {
		kullanici = kullaniciRepository.findOne(id);
	}
	
	public void yenile() {
		kullanici = new Kullanici();
	}
	
	public void s�rala() {
		System.out.println("lazy load aktif");
		
		lazyDataModel = new LazyDataModel<Kullanici>() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public List<Kullanici> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				PageRequest pageRequest = new PageRequest(first/pageSize, pageSize);
				Page<Kullanici> liste = kullaniciRepository.getAllByOrderByIdAsc(pageRequest);
				this.setRowCount((int) liste.getTotalElements());
				return liste.getContent();
			}
		};
	}
	
	public EnumKullaniciRol[] getRol() {
        return EnumKullaniciRol.values();
    }
}
