package gov.ca.emsa.pulse.broker.dto;

import java.util.Date;

import gov.ca.emsa.pulse.broker.entity.QueryOrganizationStatusMap;

public class QueryOrganizationDTO {

	private Long id;
	private Long queryId;
	private Long orgId;
	private String status;
	private Date startDate;
	private Date endDate;
	private Boolean fromCache;
	
	public QueryOrganizationDTO(){}
	
	public QueryOrganizationDTO(QueryOrganizationStatusMap entity)
	{
		if(entity != null) {
			this.id = entity.getId();
			this.queryId = entity.getQueryId();
			this.orgId = entity.getOrganizationId();
			this.status = entity.getStatus();
			this.startDate = entity.getStartDate();
			this.endDate = entity.getEndDate();
			this.fromCache = entity.getFromCache();
		}
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getQueryId() {
		return queryId;
	}

	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getFromCache() {
		return fromCache;
	}

	public void setFromCache(Boolean fromCache) {
		this.fromCache = fromCache;
	}
}