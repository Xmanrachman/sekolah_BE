/**
 * 
 */
package com.managemen.sekolah.doa.model.master;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.math3.analysis.function.Inverse;

import com.managemen.sekolah.doa.model.audit.LogAudit;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@Entity(name = "MatapelajaranEntity")
@Table(name = "matapelajaran")
@AllArgsConstructor
@NoArgsConstructor
public class MatapelajaranEntity implements Serializable {

	private static final long serialVersionUID = 10l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_matapelajaran")
	private Integer idMatapelajaran;
	
	@Column(name = "nama_matapelajaran")
	private String namaMatapelajaran;
	
	@Column(name = "kode_matapelajaran")
	private String kodeMatapelajaran;
	
	@Column(name = "bobot_nilai_matapelajaran")
	private Integer bobotNilaiMatapelajaran;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "matapelajaran_guru", 
	joinColumns = @JoinColumn(name = "id_matapelajaran_rel", referencedColumnName = "id_matapelajaran"),
	inverseJoinColumns  = @JoinColumn(name = "id_guru_rel", referencedColumnName = "id_guru"))
	private Set<GuruEntity> guruEntitys;
	 
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "matapelajaran_siswa",
	joinColumns = @JoinColumn(name = "id_matapelajaran_rel", referencedColumnName = "id_matapelajaran"),
	inverseJoinColumns = @JoinColumn(name = "id_siswa_rel", referencedColumnName = "id_siswa"))
	private Set<SiswaEntity> sisawaEntitys;
	
	@Embedded
	private LogAudit logsAudit;
}
