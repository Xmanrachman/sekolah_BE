/**
 * 
 */
package com.managemen.sekolah.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.managemen.sekolah.constant.AppConstant;
import com.managemen.sekolah.doa.model.audit.LogAudit;
import com.managemen.sekolah.doa.model.master.GuruEntity;
import com.managemen.sekolah.doa.model.master.SiswaEntity;
import com.managemen.sekolah.dto.master.GuruDto;
import com.managemen.sekolah.dto.master.SiswaDto;
import com.managemen.sekolah.util.DateUtil;

@Component
public class SiswaMapper {

	public LogAudit createdAudit() {
		LogAudit audit = new LogAudit();
		audit.setDateCreated(new Date());
		audit.setUserCreated("SYSTEM");
		return audit;
	}
	
	public LogAudit modifiedAudit(SiswaEntity entity) {
		LogAudit audit = entity.getLogsAudit();
		audit.setDateModified(new Date());
		audit.setUserModified("SYSTEM");
		return audit;
	}
	
	
	public SiswaEntity entryDataSiswa(SiswaDto requestMapper) {
		
		SiswaEntity siswaEntity = new SiswaEntity();
		
		//siswaEntity.setIdSiswa(requestMapper.getIdSiswa());
		siswaEntity.setJenisKelamin(requestMapper.getJenisKelamin());
		siswaEntity.setNamaMahasiswa(requestMapper.getNamaMahasiswa());
		siswaEntity.setNim(requestMapper.getNim());
		siswaEntity.setTanggalLahir(DateUtil.convertDateToDate(requestMapper.getTanggalLahir(), AppConstant.ACCEPTED_DATETIME_FORMAT) );
		siswaEntity.setTempatLahir(requestMapper.getTempatLahir());
		siswaEntity.setUmur(requestMapper.getUmur());
		
		siswaEntity.setLogsAudit(createdAudit());
		return siswaEntity;
	}
	
	public List<Object> inqueryAll(List<SiswaEntity> requestList) {
		
		List<Object> siswaList = new ArrayList<Object>();
		 
		 for (SiswaEntity siswaData : requestList) {
			 SiswaDto siswaResponseDto = new SiswaDto();
			 
			 siswaResponseDto.setIdSiswa(siswaData.getIdSiswa());
			 siswaResponseDto.setNamaMahasiswa(siswaData.getNamaMahasiswa());
			 siswaResponseDto.setJenisKelamin(siswaData.getJenisKelamin());
			 siswaResponseDto.setTanggalLahir(siswaData.getTanggalLahir());
			 siswaResponseDto.setTempatLahir(siswaData.getTempatLahir());
			 siswaResponseDto.setUmur(siswaData.getUmur());
			 
			 siswaList.add(siswaResponseDto);
		 }
		return siswaList;
	}
	
	
	 
	 public SiswaDto inquerySearchByNIm(SiswaEntity request) {
		
			 SiswaDto siswaResponseDto = new SiswaDto();
			 
			 siswaResponseDto.setIdSiswa(request.getIdSiswa());
			 siswaResponseDto.setNamaMahasiswa(request.getNamaMahasiswa());
			 siswaResponseDto.setJenisKelamin(request.getJenisKelamin());
			 siswaResponseDto.setTanggalLahir(request.getTanggalLahir());
			 siswaResponseDto.setTempatLahir(request.getTempatLahir());
			 siswaResponseDto.setUmur(request.getUmur());
			 
			 return siswaResponseDto;
	 }

	
}
