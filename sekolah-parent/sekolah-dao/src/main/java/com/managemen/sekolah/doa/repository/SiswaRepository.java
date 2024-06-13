package com.managemen.sekolah.doa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;

import com.managemen.sekolah.doa.model.master.SiswaEntity;

@Repository
public interface SiswaRepository extends JpaRepository<SiswaEntity, Integer>, JpaSpecificationExecutor<SiswaEntity>{
	Optional<SiswaEntity> findByIdSiswa(Integer idSiswa);
	Optional<SiswaEntity> findByNim(String nim);
}
