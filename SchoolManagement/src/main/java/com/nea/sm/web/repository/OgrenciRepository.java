package com.nea.sm.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nea.sm.web.entity.Ogrenci;

@Repository
public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

	// Öðrencileri grup id lerine göre getirme
	List<Ogrenci> getGrupById(Long id);
}
