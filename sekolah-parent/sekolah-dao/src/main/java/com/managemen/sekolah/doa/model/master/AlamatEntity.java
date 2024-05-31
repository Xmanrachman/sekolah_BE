/**
 * 
 */
package com.managemen.sekolah.doa.model.master;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */

@Data
@Entity(name = "AlamatEntity")
@Table(name = "alamat")
@AllArgsConstructor
@NoArgsConstructor
public class AlamatEntity implements Serializable {

	private static final long serialVersionUID = 10L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_alamat")
	private Integer idAlamat;
	
	@Column(name = "jalan")
	private String jalanAlamat;
	
	@Column(name = "kota")
	private String kota;
	
	@Column(name = "provinsi")
	private String provinsi;
	
	@Column(name = "kecamatan")
	private String kecamatan;
	
	@Column(name = "kelurahan")
	private String kelurahan;
	
	@Column(name = "kode_pos")
	private String kodePos;
	
	@Column(name = "no_rt")
	private String noRt;
	
	@Column(name = "no_rw")
	private String noRW;
	
	@Column(name = "nomor_rumah")
	private String nomorRumah;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_siswa", referencedColumnName = "id_siswa")
	private SiswaEntity siswaEntity;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_guru", referencedColumnName = "id_guru")
	private GuruEntity guruEntity;
	
	
	

}
