package com.nea.sm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nea.sm.entity.Yoklama;

@Repository
public interface YoklamaRepository extends JpaRepository<Yoklama, Long>{

}
