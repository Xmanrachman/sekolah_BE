package com.managemen.sekolah.controller.siswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.managemen.sekolah.dto.master.SiswaDto;
import com.managemen.sekolah.master.siswa.InquerySiswaService;
import com.managemen.sekolah.response.ResponseInquery;

@RestController
public class InquerySiswaController {

	@Autowired
	private InquerySiswaService inquerySiswaService;
	
	@RequestMapping(value = "/inquery/getallsiswa")
	public ResponseInquery inqyeryAll() {
		return inquerySiswaService.inqueryAllSiswa();
	}
	
	@RequestMapping(value = "/inquery/getnim")
	public ResponseInquery inqueryByNim(@RequestBody SiswaDto requestDto) {
		return inquerySiswaService.inquerySearchByNim(requestDto);
	}
	
}
