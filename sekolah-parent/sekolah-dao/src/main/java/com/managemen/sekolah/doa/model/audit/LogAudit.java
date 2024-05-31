/**
 * 
 */
package com.managemen.sekolah.doa.model.audit;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

/**
 * 
 */
@Data
@Embeddable
public class LogAudit implements Serializable {
	
		private static final long serialVersionUID = 1L;
		
		@Column(name = "user_created_audit")
		private String userCreated;
		
		@Column(name = "date_created_audit")
		private Date dateCreated;
		
		@Column(name = "user_modified_audit")
		private String userModified;
		
		@Column(name = "date_modified_audit")
		private Date dateModified;
		


}
