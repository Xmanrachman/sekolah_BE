package com.managemen.sekolah.master.guru;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managemen.sekolah.doa.model.master.AlamatEntity;
import com.managemen.sekolah.doa.model.master.GuruEntity;
import com.managemen.sekolah.doa.repository.AlamatRepository;
import com.managemen.sekolah.doa.repository.GuruRepository;
import com.managemen.sekolah.dto.master.GuruDto;
import com.managemen.sekolah.mapper.GuruMapper;
import com.managemen.sekolah.response.ResponseInquery;

@Service
public class InqueryGuruService {
	
	@Autowired
	private GuruRepository guruRepository;
	@Autowired
	private GuruMapper guruMapper;
	@Autowired
	private AlamatRepository alamatRepo;
	
	
	public ResponseInquery inqueryAllGuru() {
		
		ResponseInquery responseInq = new ResponseInquery();
		
		List<GuruEntity> listGuruEntity = guruRepository.findAll();
		
		if (!listGuruEntity.isEmpty()) {
			List<Object> listGuruObject = guruMapper.inqueryAll(listGuruEntity);
			
			responseInq.setInfo("Data guru send succesfuly");
			responseInq.setStatus(HttpStatus.SC_OK);
			responseInq.setContent(listGuruObject);
			
		} else {
			responseInq.setInfo("Data guru Empty");
			responseInq.setStatus(HttpStatus.SC_BAD_REQUEST);
			responseInq.setContent(new ArrayList<Object>());
		}
		return responseInq;
	}
	
	public ResponseInquery inqSearchByKodeGuru(GuruDto guruDto) {
		ResponseInquery responseInq = new ResponseInquery();
		GuruDto guruResponse = null;
		
		if (!guruDto.getKodeGuru().equals(0) || guruDto.getKodeGuru() != null) {
			Optional<GuruEntity> guruOpt = guruRepository.findByKodeGuru(guruDto.getKodeGuru());
			
			if (guruOpt.isPresent()) {
				Optional<AlamatEntity> alamatOpt = alamatRepo.findByGuruEntity(guruOpt.get());
				if (alamatOpt.isPresent())
					guruResponse = guruMapper.inquerySearchByKodeGuru(guruOpt.get(),alamatOpt.get());
					responseInq.setInfo("Data Guru by kode guru");
					responseInq.setStatus(HttpStatus.SC_OK);
					responseInq.setContentObj(guruResponse);
			}
		} else {
			responseInq.setInfo("Data Guru not found");
			responseInq.setStatus(HttpStatus.SC_BAD_REQUEST);
			responseInq.setContentObj(guruResponse);
		}
		return responseInq;
	}

}
