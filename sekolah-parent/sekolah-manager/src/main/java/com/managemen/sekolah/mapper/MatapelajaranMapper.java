package com.managemen.sekolah.mapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.managemen.sekolah.doa.model.audit.LogAudit;
import com.managemen.sekolah.doa.model.master.MatapelajaranEntity;
import com.managemen.sekolah.doa.model.master.SiswaEntity;
import com.managemen.sekolah.dto.master.MatapelajaranDto;

@Component
public class MatapelajaranMapper {
	
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
	
	public MatapelajaranEntity entryDataMatapelajaran(MatapelajaranDto request) {
		
		MatapelajaranEntity matapelajaranEntity = new MatapelajaranEntity();
		
		matapelajaranEntity.setNamaMatapelajaran(request.getNamaMatapelajaran());
		matapelajaranEntity.setKodeMatapelajaran(request.getKodeMatapelajaran());
		matapelajaranEntity.setBobotNilaiMatapelajaran(request.getBobotNilaiMatapelajaran());
		
		matapelajaranEntity.setGuruEntitys(null);
		
		matapelajaranEntity.setLogsAudit(createdAudit());
		
		return matapelajaranEntity;
	}

}
