package com.nea.sm.controller;

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

import com.nea.sm.entity.Grup;
import com.nea.sm.entity.Salon;
import com.nea.sm.repository.GrupRespository;
import com.nea.sm.repository.SalonRepository;

import lombok.Getter;
import lombok.Setter;

@Controller("grupController")
@Scope("session")
public class GrupController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private GrupRespository grupRespository;
	
	@Autowired
	private SalonRepository salonRepository;
	
	@Getter @Setter
	private LazyDataModel<Grup> lazyDataModel;
	
	@Getter @Setter
	private List<Salon> salonList;
	
	@Getter @Setter
	private Grup grup;
	
	@PostConstruct
	public void init() {
		System.out.println("Kullan�c�-Post Construct olu�turuldu");
		s�rala();
		grup = new Grup();
		salonList = salonRepository.findAll();
	}
	
	public void grupKaydet() {
		if (grup != null) {
			grupRespository.save(grup);
		}
	}

	public void grupG�ncelle(Long id) {
		System.out.println("Grup guncellendi");
		Grup grup = grupRespository.findOne(id);
		grupRespository.delete(grup);
		s�rala();
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("BA�ARILI",  "Grup Silindi") );
	}
	
	public void grupSil(Long id) {
		System.out.println("Grup silindi");
		grup = new Grup();
	}

	public void s�rala() {
		System.out.println("lazy load aktif");
		
		lazyDataModel = new LazyDataModel<Grup>() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public List<Grup> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				PageRequest pageRequest = new PageRequest(first/pageSize, pageSize);
				Page<Grup> liste = grupRespository.findAll(pageRequest);
				this.setRowCount((int) liste.getTotalElements());
				return liste.getContent();
			}
		};

	}
	
}
