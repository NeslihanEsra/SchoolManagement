package com.nea.sm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nea.sm.entity.YoklamaDetay;

@Repository
public interface YoklamaDetayRepository extends JpaRepository<YoklamaDetay, Long>{

}
