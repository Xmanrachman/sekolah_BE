/**
 * 
 */
package com.managemen.sekolah.master.siswa;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.managemen.sekolah.doa.model.master.AlamatEntity;
import com.managemen.sekolah.doa.model.master.SiswaEntity;
import com.managemen.sekolah.doa.repository.AlamatRepository;
import com.managemen.sekolah.doa.repository.SiswaRepository;
import com.managemen.sekolah.dto.master.SiswaDto;
import com.managemen.sekolah.mapper.AlamatMapper;
import com.managemen.sekolah.mapper.SiswaMapper;
import com.managemen.sekolah.response.GeneralResponse;


@Service
public class EntrySiswaService {

	@Autowired
	private SiswaRepository siswaRepository;

	@Autowired
	private AlamatRepository alamatRepository;

	@Autowired
	private SiswaMapper siswaMapper;

	@Autowired
	private AlamatMapper alamatMapper;

	public ResponseEntity<Object> entryDataSiswa(SiswaDto requestSiswa) {

		GeneralResponse<Object> response = new GeneralResponse<>();
		
		boolean msgResponse = false;
		if (requestSiswa.equals(null)) {
			
			response.setInfo("Data null");
			response.setStatus(HttpStatus.SC_NO_CONTENT);
			return ResponseEntity.status(response.getStatus()).body(response);
		} else if (requestSiswa.getIdSiswa() != 0) {
			response.setInfo("Data not entry");
			response.setStatus(HttpStatus.SC_BAD_REQUEST);
			return ResponseEntity.status(response.getStatus()).body(response);
		}

		SiswaEntity siswaEntity = siswaMapper.entryDataSiswa(requestSiswa);
		siswaRepository.save(siswaEntity);
		
		if (siswaEntity.getIdSiswa() != 0) {
			AlamatEntity alamatEntity = alamatMapper.entrySiswaAlamat(requestSiswa, siswaEntity);
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
