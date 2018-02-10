package com.nea.sm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nea.sm.entity.Kullanici;

@Repository
@Transactional
public interface KullaniciRepository extends JpaRepository<Kullanici, Long>{

	List<Kullanici> findAllByOrderByIdAsc();
	
	//kullanýcý adýna göre sýralar
	Kullanici getByKullaniciAdi(String kullaniciAdi);
}
