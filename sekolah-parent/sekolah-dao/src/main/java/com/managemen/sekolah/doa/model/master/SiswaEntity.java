/**
 * 
 */
package com.managemen.sekolah.doa.model.master;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.managemen.sekolah.doa.model.audit.LogAudit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@Entity(name = "SiswaEntity")
@Table(name = "mahasiswa")
@AllArgsConstructor
@NoArgsConstructor
public class SiswaEntity implements Serializable {
	
	private static final long serialVersionUID = 10L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_siswa")
	private Integer idSiswa;
	
	@Column(name = "nim")
	private String nim;
	
	@Column(name = "nama_mahasiswa")
	private String namaMahasiswa;
	
	@Column(name = "umur_mahasiswa")
	private Integer umur;
	
	@Column(name = "jenis_kelamin")
	private String jenisKelamin;
	
	@Column(name = "tempat_lahir")
	private String tempatLahir;
	
	@Column(name = "tanggal_lahir")
	private Date tanggalLahir;
	
	@ManyToMany(mappedBy = "sisawaEntitys")
	private Set<SiswaEntity> siswaRelation = new HashSet<>();
	
	
	
	@Embedded
	private LogAudit logsAudit;
	

}
