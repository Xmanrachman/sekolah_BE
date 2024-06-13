/**
 * 
 */
package com.managemen.sekolah.doa.model.master;

import java.io.Serializable;
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
	
	@ManyToMany()
	private Set<GuruEntity> guruEntitys = new HashSet<>();
	 
	
	@Embedded
	private LogAudit logsAudit;
}
