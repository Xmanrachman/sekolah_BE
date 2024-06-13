package com.managemen.sekolah.master.matapelajaran;

import org.apache.http.HttpStatus;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.managemen.sekolah.doa.model.master.MatapelajaranEntity;
import com.managemen.sekolah.doa.repository.MatapelajaranRepository;
import com.managemen.sekolah.dto.master.MatapelajaranDto;
import com.managemen.sekolah.mapper.MatapelajaranMapper;
import com.managemen.sekolah.response.GeneralResponse;

@Service
public class EntryMatapelajaranService {
	
	@Autowired
	private MatapelajaranMapper matapelajaranMapper;
	
	@Autowired
	private MatapelajaranRepository matapelajaranRepo;
	
	public ResponseEntity<GeneralResponse<T>> entryMatapelajaran(MatapelajaranDto request) {
		GeneralResponse<T> response = new GeneralResponse<>();
		
		boolean msgResponse = false;
		if (request.equals(null)) {
			
			response.setInfo("Data null");
			response.setStatus(HttpStatus.SC_NO_CONTENT);
			return ResponseEntity.status(response.getStatus()).body(response);
			
		} else if (request.getIdMatapelajaran() != 0) {
			response.setInfo("Data not entry");
			response.setStatus(HttpStatus.SC_BAD_REQUEST);
			return ResponseEntity.status(response.getStatus()).body(response);
		}

		MatapelajaranEntity matapelajaranEntity = matapelajaranMapper.entryDataMatapelajaran(request);
		matapelajaranRepo.save(matapelajaranEntity);
		
		if (matapelajaranEntity.getIdMatapelajaran() != 0) {
			msgResponse = true;
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
