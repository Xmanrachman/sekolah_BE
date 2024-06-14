package com.managemen.sekolah.dto.master;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatapelajaranDto {
	
	@JsonProperty("id_matapelajaran")
	private Integer idMatapelajaran;
	
	@JsonProperty("nama_matapelajaran")
	private String namaMatapelajaran;
	
	@JsonProperty("kode_metapelajaran")
	private String kodeMatapelajaran;
	
	@JsonProperty("kode_matapelajaran")
	private Integer bobotNilaiMatapelajaran;
	
	@JsonProperty("id_guru")
	private Integer idGuru;
	
	@JsonProperty("id_siswa")
	private Integer idSiswa;
	
}
