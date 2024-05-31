package com.managemen.sekolah.mapper;

import org.springframework.stereotype.Component;

import com.managemen.sekolah.doa.model.master.AlamatEntity;
import com.managemen.sekolah.doa.model.master.GuruEntity;
import com.managemen.sekolah.doa.model.master.SiswaEntity;
import com.managemen.sekolah.dto.master.GuruDto;
import com.managemen.sekolah.dto.master.SiswaDto;

@Component
public class AlamatMapper {

	public AlamatEntity entrySiswaAlamat(SiswaDto request, SiswaEntity siswaId) {

		AlamatEntity alamat = new AlamatEntity();

		alamat.setJalanAlamat(request.getJalan());
		alamat.setKota(request.getKota());
		alamat.setProvinsi(request.getProvinsi());
		alamat.setKelurahan(request.getKelurahan());
		alamat.setKecamatan(request.getKecamatan());
		alamat.setKodePos(request.getKodePos());
		alamat.setNoRW(request.getNoRw());
		alamat.setNoRt(request.getNoRt());
		alamat.setNomorRumah(request.getNomorRumah());
		alamat.setSiswaEntity(siswaId);

		return alamat;
	}

	public AlamatEntity entryGuruAlamat(GuruDto request, GuruEntity guruId) {

		AlamatEntity alamat = new AlamatEntity();

		alamat.setJalanAlamat(request.getJalan());
		alamat.setKota(request.getKota());
		alamat.setProvinsi(request.getProvinsi());
		alamat.setKelurahan(request.getKelurahan());
		alamat.setKecamatan(request.getKecamatan());
		alamat.setKodePos(request.getKodePos());
		alamat.setNoRW(request.getNoRw());
		alamat.setNoRt(request.getNoRt());
		alamat.setNomorRumah(request.getNomorRumah());
		alamat.setGuruEntity(guruId);

		return alamat;
	}
}
