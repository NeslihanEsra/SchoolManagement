package com.nea.sm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nea.sm.entity.Kurs;

@Repository
public interface KursRepository extends JpaRepository<Kurs, Long>{

	List<Kurs> getAllByOrderByIdAsc();
}
