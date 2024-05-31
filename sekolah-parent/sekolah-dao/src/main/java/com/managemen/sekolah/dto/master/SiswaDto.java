/**
 * 
 */
package com.managemen.sekolah.dto.master;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SiswaDto {
	
	@JsonProperty("id_siswa")
	private Integer idSiswa;
	
	@JsonProperty("nim")
	private String nim;
	
	@JsonProperty("nama_mahasiswa")
	private String namaMahasiswa;
	
	@JsonProperty("umur_mahasiswa")
	private Integer umur;
	
	@JsonProperty("jenis_kelamin")
	private String jenisKelamin;
	
	@JsonProperty("tempat_lahir")
	private String tempatLahir;
	
	@JsonProperty("tanggal_lahir")
	private Date tanggalLahir;
	
	@JsonProperty("jalan")
	private String jalan;
	
	@JsonProperty("kota")
	private String kota;
	
	@JsonProperty("provinsi")
	private String provinsi;
	
	@JsonProperty("kecamatan")
	private String kecamatan;
	
	@JsonProperty("kelurahan")
	private String kelurahan;
	
	@JsonProperty("kode_pos")
	private String kodePos;
	
	@JsonProperty("no_rt")
	private String noRt;
	
	@JsonProperty("no_rw")
	private String noRw;
	
	@JsonProperty("nomor_rumah")
	private String nomorRumah;
	

}
