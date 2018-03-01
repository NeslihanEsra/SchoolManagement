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

import com.nea.sm.web.entity.YonetimGrup;
import com.nea.sm.web.entity.YonetimKurs;
import com.nea.sm.web.entity.IKOgretmen;
import com.nea.sm.web.entity.YonetimSalon;
import com.nea.sm.web.repository.GrupRespository;
import com.nea.sm.web.repository.KursRepository;
import com.nea.sm.web.repository.OgretmenRepository;
import com.nea.sm.web.repository.SalonRepository;

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
	
	@Autowired
	private OgretmenRepository ogretmenRepository;
	
	@Autowired
	private KursRepository kursRepository;
	
	@Getter @Setter
	private LazyDataModel<YonetimGrup> lazyDataModel;
	
	@Getter @Setter
	private List<YonetimSalon> salonList;
	
	@Getter @Setter
	private List<YonetimKurs> kursList;
	
//	@Getter @Setter
//	private List<Ogretmen> ogretmenList;
	
	@Getter @Setter
	private YonetimGrup grup;
	
	@PostConstruct
	public void init() {
		System.out.println("Kullanýcý-Post Construct oluþturuldu");
		sýrala();
		grup = new YonetimGrup();
		salonList = salonRepository.getAllByOrderByIdAsc();
		//ogretmenList = ogretmenRepository.getAllByOrderByIdAsc();
		kursList = kursRepository.getAllByOrderByIdAsc();
	}
	
	public void grupKaydet() {
		if (grup != null) {
			grupRespository.save(grup);
		}
		sýrala();
	}
	
	public void grupSil(Long id) {
		System.out.println("Grup silindi");
		YonetimGrup grup = grupRespository.findOne(id);
		grupRespository.delete(grup);
		sýrala();
	}
	
	public void yenile() {
		grup = new YonetimGrup();
	}
	
	public void grupGuncelle(Long id) {
		grup = grupRespository.findOne(id);
	}

	public void sýrala() {
		System.out.println("lazy load aktif");
		
		lazyDataModel = new LazyDataModel<YonetimGrup>() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public List<YonetimGrup> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				PageRequest pageRequest = new PageRequest(first/pageSize, pageSize);
				Page<YonetimGrup> liste = grupRespository.getAllByOrderByIdAsc(pageRequest);
				this.setRowCount((int) liste.getTotalElements());
				return liste.getContent();
			}
		};
	}
	
	public List<IKOgretmen> ogretmenAutoComplete(String query) {
		List<IKOgretmen> list = ogretmenRepository.getByName(query);
		return list;
	}

}