package com.managemen.sekolah.doa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.managemen.sekolah.doa.model.master.AlamatEntity;

@Repository
public interface AlamatRepository extends JpaRepository<AlamatEntity, Integer>, JpaSpecificationExecutor<AlamatEntity> {

	Optional<AlamatEntity> findByIdAlamat(Integer IdAlamat);
	
}
