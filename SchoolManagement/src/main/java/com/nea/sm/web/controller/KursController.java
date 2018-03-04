package com.nea.sm.web.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import com.nea.sm.web.entity.YonetimKurs;
import com.nea.sm.web.repository.KursRepository;

import lombok.Getter;
import lombok.Setter;

@Controller("kursController")
@Scope("session")
public class KursController implements Serializable {

	@Autowired
	private KursRepository kursRepository;

	@Getter @Setter
	private LazyDataModel<YonetimKurs> lazyDataModel;
	
	@Getter @Setter
	private YonetimKurs kurs;

	@PostConstruct
	private void init() {
		System.out.println("Kurs post construct oluþturuldu");
		sýrala();
		kurs = new YonetimKurs();
	}

	public void sýrala() {
		lazyDataModel = new LazyDataModel<YonetimKurs>() {

			private static final long serialVersionUID = 1L;

			@Override
			public List<YonetimKurs> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
				PageRequest pageRequest = new PageRequest(first / pageSize, pageSize);
				Page<YonetimKurs> liste = kursRepository.getAllByOrderByIdAsc(pageRequest);
				this.setRowCount((int) liste.getTotalElements());
				return liste.getContent();
			}
		};
	}
	
	public void kursSil(Long id) {
		YonetimKurs kurs = kursRepository.findOne(id);
		kursRepository.delete(kurs);
		sýrala();
	}
	
	public void kursGuncelle(Long id) {
		kursRepository.findOne(id);
	}
	
	public void yenile() {
		kurs = new YonetimKurs();
	}
	
	public void kursKaydet() {
		kursRepository.save(kurs);
		sýrala();
		kurs = new YonetimKurs();
	}

}
