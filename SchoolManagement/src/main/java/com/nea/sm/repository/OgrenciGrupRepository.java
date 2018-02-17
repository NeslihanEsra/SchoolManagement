package com.nea.sm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nea.sm.entity.OgrenciGrup;

@Repository
public interface OgrenciGrupRepository extends JpaRepository<OgrenciGrup, Long> {

	// ��rencileri grup id lerine g�re getirme
	List<OgrenciGrup> getGrupById(Long grupId);
}
