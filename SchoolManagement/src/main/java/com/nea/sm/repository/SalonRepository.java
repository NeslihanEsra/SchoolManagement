package com.nea.sm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nea.sm.entity.Salon;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long>{

}
