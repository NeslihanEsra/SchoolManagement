package com.nea.sm.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nea.sm.web.entity.Yoklama;

@Repository
public interface YoklamaRepository extends JpaRepository<Yoklama, Long>{
	List<Yoklama> getByGrupId(Long grupId);
	
	@Query(value = "SELECT * FROM yoklama WHERE grup = %?1% ", nativeQuery = true)
	List<Yoklama> getByGrupId(String query);


}
