package com.nea.sm.web.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nea.sm.web.entity.YonetimKurs;

@Repository
public interface KursRepository extends JpaRepository<YonetimKurs, Long>{

	List<YonetimKurs> getAllByOrderByIdAsc();
	
	Page<YonetimKurs> getAllByOrderByIdAsc(Pageable pageable);
}
