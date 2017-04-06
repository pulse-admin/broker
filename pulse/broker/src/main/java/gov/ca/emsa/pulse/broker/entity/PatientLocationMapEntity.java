package gov.ca.emsa.pulse.broker.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="patient_location_map")
public class PatientLocationMapEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id", nullable = false )
	private Long id;
	
	@Column(name = "patient_id")
	private Long patientId;
	
	@OneToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "patient_id", unique=true, nullable = true, insertable=false, updatable= false)
	private PatientEntity patient;
	
	@Column(name = "location_id")
	private Long locationId;
	
	@OneToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "location_id", unique=true, nullable = true, insertable=false, updatable= false)
	private LocationEntity location;
	
	@Column(name = "location_patient_record_id")
	private String externalPatientRecordId;
	
	@Column(name = "home_community_id")
	private String homeCommunityId;

	@Column(name = "documents_query_status_id")
	private Long documentsQueryStatusId;
	
	@Basic( optional = true )
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "documents_query_status_id", unique=true, nullable = false, insertable=false, updatable= false)
	private QueryLocationStatusEntity status;
	
	@Column(name = "documents_query_start")
	private Date documentsQueryStart;
	
	@Column(name = "documents_query_end")
	private Date documentsQueryEnd;
	
	@Column( name = "creation_date", insertable = false, updatable = false)
	private Date creationDate;
	
	@Column( name = "last_modified_date", insertable = false, updatable = false)
	private Date lastModifiedDate;
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "patientLocationMapId"  )
	@Column( name = "patient_location_map_id", nullable = false  )
	private Set<DocumentEntity> documents = new HashSet<DocumentEntity>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public LocationEntity getLocation() {
		return location;
	}

	public void setLocation(LocationEntity location) {
		this.location = location;
	}

	public String getHomeCommunityId() {
		return homeCommunityId;
	}

	public void setHomeCommunityId(String homeCommunityId) {
		this.homeCommunityId = homeCommunityId;
	}

	public String getExternalPatientRecordId() {
		return externalPatientRecordId;
	}

	public void setExternalPatientRecordId(String externalPatientRecordId) {
		this.externalPatientRecordId = externalPatientRecordId;
	}

	public Date getDocumentsQueryStart() {
		return documentsQueryStart;
	}

	public void setDocumentsQueryStart(Date documentsQueryStart) {
		this.documentsQueryStart = documentsQueryStart;
	}

	public Date getDocumentsQueryEnd() {
		return documentsQueryEnd;
	}

	public void setDocumentsQueryEnd(Date documentsQueryEnd) {
		this.documentsQueryEnd = documentsQueryEnd;
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

	public Set<DocumentEntity> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<DocumentEntity> documents) {
		this.documents = documents;
	}

	public Long getDocumentsQueryStatusId() {
		return documentsQueryStatusId;
	}

	public void setDocumentsQueryStatusId(Long documentsQueryStatusId) {
		this.documentsQueryStatusId = documentsQueryStatusId;
	}

	public QueryLocationStatusEntity getStatus() {
		return status;
	}

	public void setStatus(QueryLocationStatusEntity status) {
		this.status = status;
	}
	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}
}