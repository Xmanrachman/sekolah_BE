package com.managemen.sekolah.controller.guru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.managemen.sekolah.dto.master.GuruDto;
import com.managemen.sekolah.master.guru.EntryGuruService;

@RestController
public class EntryGuruController {
	
	@Autowired
	private EntryGuruService guruService;
	
	@PostMapping("/entry/guru")
	public ResponseEntity<Object> entryDataGuru(@RequestBody GuruDto request) {
		return guruService.entryDataGuru(request);
	}

}
