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

import com.nea.sm.web.entity.EnumCinsiyet;
import com.nea.sm.web.entity.Ogrenci;
import com.nea.sm.web.repository.OgrenciRepository;
import com.nea.sm.web.service.OgrenciService;

import lombok.Getter;
import lombok.Setter;

@Controller("ogrenciController")
@Scope("session")
public class OgrenciController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private OgrenciRepository ogrenciRepository;
	
	@Autowired
	private OgrenciService ogrenciService;
	
	@Getter @Setter
	private Ogrenci ogrenci;
	
	@Getter @Setter
	private List<Ogrenci> ogrenciList;
	
	@Setter
	private EnumCinsiyet cinsiyet;
	
	@Getter 
	private LazyDataModel<Ogrenci> lazyDataModel;
	
	@PostConstruct
	public void init() {
		System.out.println("Ogrenci Post Construct oluþturuldu");
		sýrala();
		ogrenci = new Ogrenci();
	}
	
	public void sýrala() {
		System.out.println("lazy load aktif");
		lazyDataModel = new LazyDataModel<Ogrenci>() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public List<Ogrenci> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				PageRequest pageRequest = new PageRequest(first/pageSize, pageSize);
				Page<Ogrenci> liste = ogrenciRepository.getAllByOrderByIdAsc(pageRequest);
				this.setRowCount((int) liste.getTotalElements());
				return liste.getContent();
			}
		};
	}
	
	public void ogrenciKaydet() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			ogrenciService.save(ogrenci);
			sýrala();
			context.addMessage(null, new FacesMessage("BAÞARILI",  "Ýþlem gerçekleþtirildi") );
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HATA",  "Ýþlem baþarýsýz") );
		}
		ogrenci = new Ogrenci();
	}
	
	public void ogrenciSil(Long id) {
		Ogrenci ogr = ogrenciRepository.findOne(id);
		ogrenciRepository.delete(ogr);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("BAÞARILI",  "Kayýt silindi") );
		sýrala();
	}
	
	public void ogrenciGuncelle(Long id) {
		ogrenci = ogrenciRepository.findOne(id);
	}
	
	public void yeniOgrenci() {
		ogrenci = new Ogrenci();
	}
	
	public EnumCinsiyet[] getCinsiyet(){
		return EnumCinsiyet.values();
	}
	
	
}
