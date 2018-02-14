package com.nea.sm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nea.sm.entity.Kullanici;
import com.nea.sm.entity.Ogretmen;

@Repository
public interface OgretmenRepository extends JpaRepository<Ogretmen, Long> {

	List<Ogretmen> getAllByOrderByIdAsc();

	@Query(value = "SELECT * FROM ogretmen WHERE ad ilike %?1% or soyad ilike %?1%", nativeQuery = true)
	List<Ogretmen> getByName(String query);

}
