package com.managemen.sekolah.controller.siswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.managemen.sekolah.dto.master.SiswaDto;
import com.managemen.sekolah.master.siswa.EntrySiswaService;

@RestController
public class EntrySiswaController {
	
	@Autowired
	private EntrySiswaService entrySiswaService;

	@PostMapping("/entry/siswa")
	public ResponseEntity<Object> entrySiswa(@RequestBody SiswaDto request) {
		return entrySiswaService.entryDataSiswa(request);
	}
}
