package com.nea.sm.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nea.sm.entity.Kullanici;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici, Long>{

	List<Kullanici> getAllByOrderByIdAsc();
	
	//kullanýcý adýna göre sýralar
	Kullanici getByKullaniciAdi(String kullaniciAdi);
	
	Page<Kullanici> getAllByOrderByIdAsc(Pageable pageable);
}
