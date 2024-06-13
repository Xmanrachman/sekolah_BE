package com.managemen.sekolah.doa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.managemen.sekolah.doa.model.master.MatapelajaranEntity;

@Repository
public interface MatapelajaranRepository extends JpaRepository<MatapelajaranEntity, Integer>, JpaSpecificationExecutor<MatapelajaranEntity>{
	
	Optional<MatapelajaranEntity> findByIdMatapelajaran(Integer idMataPelajaran);
	
}
