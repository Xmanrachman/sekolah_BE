package com.managemen.sekolah.doa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.managemen.sekolah.doa.model.master.GuruEntity;

@Repository
public interface GuruRepository extends JpaRepository<GuruEntity, Integer>, JpaSpecificationExecutor<GuruEntity> {
	
	Optional<GuruEntity> findByIdGuru(Integer idGuru);
	Optional<List<GuruEntity>> findByKodeGuru(String kodeGuru);

}
