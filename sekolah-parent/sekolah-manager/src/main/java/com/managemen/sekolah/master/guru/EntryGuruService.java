package com.managemen.sekolah.master.guru;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.managemen.sekolah.doa.model.master.AlamatEntity;
import com.managemen.sekolah.doa.model.master.GuruEntity;
import com.managemen.sekolah.doa.model.master.SiswaEntity;
import com.managemen.sekolah.doa.repository.AlamatRepository;
import com.managemen.sekolah.doa.repository.GuruRepository;
import com.managemen.sekolah.dto.master.GuruDto;
import com.managemen.sekolah.mapper.AlamatMapper;
import com.managemen.sekolah.mapper.GuruMapper;
import com.managemen.sekolah.response.GeneralResponse;


@Service
public class EntryGuruService {

	
	@Autowired
	private AlamatRepository alamatRepository;

	@Autowired
	private AlamatMapper alamatMapper;
	
	@Autowired
	private GuruMapper guruMapper;
	@Autowired
	private GuruRepository guruRepository;
	
	
	public ResponseEntity<Object> entryDataGuru(GuruDto requestGuru) {
		
		GeneralResponse<Object> response = new GeneralResponse<>();
		
		boolean msgResponse = false;
		if (requestGuru.equals(null)) {
			response.setInfo("Data null");
			response.setStatus(HttpStatus.SC_NO_CONTENT);
			return ResponseEntity.status(response.getStatus()).body(response);
		} else if (requestGuru.getIdGuru() != 0) {
			response.setInfo("Data not entry");
			response.setStatus(HttpStatus.SC_BAD_REQUEST);
			return ResponseEntity.status(response.getStatus()).body(response);
		}

		GuruEntity guruEntity = guruMapper.entryDataGuru(requestGuru);
		guruRepository.save(guruEntity);
		
		if (guruEntity.getIdGuru() != 0) {
			AlamatEntity alamatEntity = alamatMapper.entryGuruAlamat(requestGuru, guruEntity);
			alamatRepository.saveAndFlush(alamatEntity);

			if (alamatEntity.getIdAlamat() != 0) {
				msgResponse = true;
			}
		}

		if (msgResponse == true) {
			response.setInfo("Data has been successfully Entry");
			response.setStatus(HttpStatus.SC_OK);
		} else {
			response.setInfo("Data field save ");
			response.setStatus(HttpStatus.SC_BAD_REQUEST);
		}

		return ResponseEntity.status(response.getStatus()).body(response);
		
		
	}
}
