package com.nea.sm.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nea.sm.web.entity.YonetimGrup;
import com.nea.sm.web.entity.YonetimSalon;

@Repository
public interface SalonRepository extends JpaRepository<YonetimSalon, Long>{

	List<YonetimSalon> getAllByOrderByIdAsc();
}
