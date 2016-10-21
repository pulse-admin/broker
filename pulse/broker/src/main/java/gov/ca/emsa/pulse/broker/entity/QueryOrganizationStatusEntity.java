package gov.ca.emsa.pulse.broker.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import gov.ca.emsa.pulse.common.domain.QueryOrganizationStatus;

@Entity
@Table(name="query_organization_status")
public class QueryOrganizationStatusEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id", nullable = false )
	private Long id;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	//@Type(type = "gov.ca.emsa.pulse.common.domain.QueryOrganizationStatus", 
	//	parameters ={@org.hibernate.annotations.Parameter(name = "enumClassName",value = "gov.ca.emsa.pulse.broker.entity.PostgresEnumType")} )
	private QueryOrganizationStatus status;
	
	@Column( name = "creation_date", insertable = false, updatable = false)
	private Date creationDate;
	
	@Column( name = "last_modified_date", insertable = false, updatable = false)
	private Date lastModifiedDate;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long long1) {
		this.id = long1;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public QueryOrganizationStatus getStatus() {
		return status;
	}

	public void setStatus(QueryOrganizationStatus status) {
		this.status = status;
	}
}
