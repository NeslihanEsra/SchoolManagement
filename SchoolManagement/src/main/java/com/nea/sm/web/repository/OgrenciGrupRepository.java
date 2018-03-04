package com.nea.sm.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nea.sm.web.entity.IKOgretmen;
import com.nea.sm.web.entity.OgrenciGrup;

@Repository
public interface OgrenciGrupRepository extends JpaRepository<OgrenciGrup, Long> {

	// Öðrencileri grup id lerine göre getirme
	List<OgrenciGrup> getGrupById(Long id);

//	List<OgrenciGrup> findAllByOrderByIdAsc();

//	@Query(value = "SELECT * FROM ogrenci_grup WHERE grup_id=%?1% ORDER BY id ASC", nativeQuery = true)
//	List<OgrenciGrup> getByGrupId(String query);
	
	List<OgrenciGrup> findById(Long id);
	
}
