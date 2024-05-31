/**
 * 
 */
package com.managemen.sekolah.doa.model.master;

import java.io.Serializable;
import java.util.Date;

import com.managemen.sekolah.doa.model.audit.LogAudit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */

@Data
@Entity(name = "GuruEntity")
@Table(name = "guru")
@AllArgsConstructor
@NoArgsConstructor
public class GuruEntity implements Serializable {
	private static final long serialVersionUID = 10L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_guru")
	private Integer idGuru;
	
	@Column(name = "kode_guru")
	private String kodeGuru;
	
	@Column(name = "nama_guru")
	private String namaGuru;
	
	@Column(name = "umur_guru")
	private Integer umur;
	
	@Column(name = "jenis_kelamin")
	private String jenisKelamin;
	
	@Column(name = "tempat_lahir")
	private String tempatLahir;
	
	@Column(name = "tanggal_lahir")
	private Date tanggalLahir;
	
	@Column(name = "jabatan_guru")
	private String jabatanGuru;
	
	@Column(name = "title_pendidikan")
	private String titlePendidikan;
	
	
	@Embedded
	private LogAudit logsAudit;
	
}
