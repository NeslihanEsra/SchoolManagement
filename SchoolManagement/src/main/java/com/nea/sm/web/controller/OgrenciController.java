package com.nea.sm.web.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

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

import lombok.Getter;
import lombok.Setter;

@Controller("ogrenciController")
@Scope("session")
public class OgrenciController implements Serializable{
	
	@Autowired
	private OgrenciRepository ogrenciRepository;
	
	@Getter @Setter
	private Ogrenci ogrenci;
	
	@Getter 
	private List<Ogrenci> ogrenciList;
	
	@Getter @Setter
	private EnumCinsiyet cinsiyet;
	
	@Getter 
	private LazyDataModel<Ogrenci> lazyDataModel;
	
	@PostConstruct
	public void init() {
		System.out.println("Ogrenci Post Construct oluþturuldu");
		sýrala();
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
	}
	
	public void ogrenciSil() {
	}
	
	public EnumCinsiyet[] getCinsiyet(){
		return EnumCinsiyet.values();
	}
	
	
}
