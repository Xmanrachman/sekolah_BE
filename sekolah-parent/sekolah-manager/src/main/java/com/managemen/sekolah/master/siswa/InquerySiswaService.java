package com.managemen.sekolah.master.siswa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managemen.sekolah.doa.model.master.AlamatEntity;

import com.managemen.sekolah.doa.model.master.SiswaEntity;
import com.managemen.sekolah.doa.repository.AlamatRepository;
import com.managemen.sekolah.doa.repository.SiswaRepository;
import com.managemen.sekolah.dto.master.SiswaDto;
import com.managemen.sekolah.mapper.SiswaMapper;
import com.managemen.sekolah.response.ResponseInquery;

@Service
public class InquerySiswaService {

	@Autowired
	private SiswaRepository siswaRepository;
	@Autowired
	private SiswaMapper siswaMapper;
	@Autowired
	private AlamatRepository alamatRepo;
	
	public ResponseInquery inqueryAllSiswa() {
		ResponseInquery responseInq = new ResponseInquery();
		
		List<SiswaEntity> listSiswaEntity = siswaRepository.findAll();

		if (!listSiswaEntity.isEmpty()) {
			List<Object> listSiswaObject = siswaMapper.inqueryAll(listSiswaEntity);

			responseInq.setInfo("Data siswa send succesfuly");
			responseInq.setStatus(HttpStatus.SC_OK);
			responseInq.setContent(listSiswaObject);
		} else {
			responseInq.setInfo("Data siswa Empty");
			responseInq.setStatus(HttpStatus.SC_BAD_REQUEST);
			responseInq.setContent(new ArrayList<Object>());
		}
		return responseInq;
	}
	
	public ResponseInquery inquerySearchByNim(SiswaDto siswaDto) {
		ResponseInquery responseInq = new ResponseInquery();
		SiswaDto siswaEntity = new SiswaDto();

		if (!siswaDto.getNim().equals(0) || siswaDto.getNim() != null) {
			Optional<SiswaEntity> siswaOpt = siswaRepository.findByNim(siswaDto.getNim());
			if (siswaOpt.isPresent()) {
				Optional<AlamatEntity> alamatOpt = alamatRepo.findBySiswaEntity(siswaOpt.get());
				if (alamatOpt.isPresent())
					siswaEntity = siswaMapper.inquerySearchByNIm(siswaOpt.get(), alamatOpt.get());
					responseInq.setInfo("Data siswa by NIM");
					responseInq.setStatus(HttpStatus.SC_OK);
					responseInq.setContentObj(siswaEntity);
					return responseInq;
			}
		}
		responseInq.setInfo("Data siswa not found");
		responseInq.setStatus(HttpStatus.SC_BAD_REQUEST);
		responseInq.setContentObj(siswaEntity);

		return responseInq;
	}
}
