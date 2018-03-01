package com.nea.sm.web.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nea.sm.web.entity.YonetimGrup;

@Repository
public interface GrupRespository extends JpaRepository<YonetimGrup, Long>{
	
	List<YonetimGrup> getAllByOrderByIdAsc();
	
	Page<YonetimGrup> getAllByOrderByIdAsc(Pageable pageable);

}
