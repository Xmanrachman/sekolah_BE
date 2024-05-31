package com.managemen.sekolah.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.managemen.sekolah.constant.AppConstant;
import com.managemen.sekolah.doa.model.audit.LogAudit;
import com.managemen.sekolah.doa.model.master.AlamatEntity;
import com.managemen.sekolah.doa.model.master.GuruEntity;
import com.managemen.sekolah.dto.master.GuruDto;
import com.managemen.sekolah.util.DateUtil;

@Component
public class GuruMapper {
	
	public LogAudit createdAudit() {
		LogAudit audit = new LogAudit();
		audit.setDateCreated(new Date());
		audit.setUserCreated("SYSTEM");
		return audit;
	}
	
	public LogAudit modifiedAudit(GuruEntity entity) {
		LogAudit audit = entity.getLogsAudit();
		audit.setDateModified(new Date());
		audit.setUserModified("SYSTEM");
		return audit;
	}
	
	
	public GuruEntity entryDataGuru(GuruDto requestMapper) {
		
		GuruEntity guruEntity = new GuruEntity();
		
		guruEntity.setJabatanGuru(requestMapper.getJabatanGuru());
		guruEntity.setTitlePendidikan(requestMapper.getTitlePendidikan());
		guruEntity.setJenisKelamin(requestMapper.getJenisKelamin());
		guruEntity.setNamaGuru(requestMapper.getNamaGuru());
		guruEntity.setKodeGuru(requestMapper.getKodeGuru());
		guruEntity.setTanggalLahir(DateUtil.convertDateToDate(requestMapper.getTanggalLahir(), AppConstant.ACCEPTED_DATETIME_FORMAT) );
		guruEntity.setTempatLahir(requestMapper.getTempatLahir());
		guruEntity.setUmur(requestMapper.getUmur());
		
		guruEntity.setLogsAudit(createdAudit());
		return guruEntity;
	}
	
	 public List<Object> inqueryAll(List<GuruEntity> request) {
		 
		 List<Object> guruList = new ArrayList<Object>();
		 
		 for (GuruEntity guruData : request) {
			 GuruDto guruResponseDto = new GuruDto();
			 
			 guruResponseDto.setIdGuru(guruData.getIdGuru());
			 guruResponseDto.setNamaGuru(guruData.getNamaGuru());
			 guruResponseDto.setJabatanGuru(guruData.getJabatanGuru());
			 guruResponseDto.setJenisKelamin(guruData.getJenisKelamin());
			 guruResponseDto.setTanggalLahir(guruData.getTanggalLahir());
			 guruResponseDto.setTempatLahir(guruData.getTempatLahir());
			 guruResponseDto.setTitlePendidikan(guruData.getTitlePendidikan());
			 guruResponseDto.setUmur(guruData.getUmur());
			 
			 guruList.add(guruResponseDto);
		 
		 }
		 
		 return guruList;
	 }
	 
	 public GuruDto inquerySearchByKodeGuru(GuruEntity request, AlamatEntity requestAlamat) {
		 
			 GuruDto guruResponseDto = new GuruDto();
			 
			 guruResponseDto.setIdGuru(request.getIdGuru());
			 guruResponseDto.setNamaGuru(request.getNamaGuru());
			 guruResponseDto.setJabatanGuru(request.getJabatanGuru());
			 guruResponseDto.setJenisKelamin(request.getJenisKelamin());
			 guruResponseDto.setTanggalLahir(request.getTanggalLahir());
			 guruResponseDto.setTempatLahir(request.getTempatLahir());
			 guruResponseDto.setTitlePendidikan(request.getTitlePendidikan());
			 guruResponseDto.setUmur(request.getUmur());
			 
			 guruResponseDto.setJalan(requestAlamat.getJalanAlamat());
			 guruResponseDto.setKota(requestAlamat.getKota());
			 guruResponseDto.setProvinsi(requestAlamat.getProvinsi());
			 guruResponseDto.setKecamatan(requestAlamat.getKecamatan());
			 guruResponseDto.setKelurahan(requestAlamat.getKelurahan());
			 guruResponseDto.setNoRt(requestAlamat.getNoRt());
			 guruResponseDto.setNoRw(requestAlamat.getNoRW());
			 guruResponseDto.setNomorRumah(requestAlamat.getNomorRumah());
			 
		 return guruResponseDto;
	 }

}
