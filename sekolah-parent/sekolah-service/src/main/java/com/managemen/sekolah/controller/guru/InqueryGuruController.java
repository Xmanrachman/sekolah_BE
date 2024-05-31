package com.managemen.sekolah.controller.guru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.managemen.sekolah.dto.master.GuruDto;
import com.managemen.sekolah.master.guru.InqueryGuruService;
import com.managemen.sekolah.response.ResponseInquery;

@RestController
public class InqueryGuruController {
	
	@Autowired
	private InqueryGuruService inqueryGuruService;
	
	@RequestMapping(value = "/inquery/getallguru")
	public ResponseInquery inqueryAll() {
		return inqueryGuruService.inqueryAllGuru();
		
	}
	
	@RequestMapping(value = "/inquery/getkodeguru")
	public ResponseInquery inqueryByKodeGuru(@RequestBody GuruDto requestGuruDto) {
		return inqueryGuruService.inqSearchByKodeGuru(requestGuruDto);
	}

}
