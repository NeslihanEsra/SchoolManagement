package com.nea.sm.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nea.sm.web.entity.Kullanici;
import com.nea.sm.web.entity.IKOgretmen;

@Repository
public interface OgretmenRepository extends JpaRepository<IKOgretmen, Long> {

	List<IKOgretmen> getAllByOrderByIdAsc();

	@Query(value = "SELECT * FROM ogretmen WHERE ad ilike %?1% or soyad ilike %?1%", nativeQuery = true)
	List<IKOgretmen> getByName(String query);

}
