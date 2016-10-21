package gov.ca.emsa.pulse.broker.manager.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ca.emsa.pulse.broker.adapter.Adapter;
import gov.ca.emsa.pulse.broker.adapter.AdapterFactory;
import gov.ca.emsa.pulse.broker.dto.OrganizationDTO;
import gov.ca.emsa.pulse.broker.dto.PatientRecordDTO;
import gov.ca.emsa.pulse.broker.dto.QueryOrganizationDTO;
import gov.ca.emsa.pulse.broker.manager.OrganizationManager;
import gov.ca.emsa.pulse.broker.manager.PatientManager;
import gov.ca.emsa.pulse.broker.manager.QueryManager;
import gov.ca.emsa.pulse.broker.saml.SAMLInput;
import gov.ca.emsa.pulse.common.domain.PatientSearch;
import gov.ca.emsa.pulse.common.domain.QueryOrganizationStatus;

@Component
public class PatientQueryService implements Runnable {
	private static final Logger logger = LogManager.getLogger(PatientQueryService.class);

	private QueryOrganizationDTO queryOrg;
	@Autowired private QueryManager queryManager;
	@Autowired private PatientManager patientManager;
	@Autowired private OrganizationManager orgManager;
	@Autowired private AdapterFactory adapterFactory;
	private PatientSearch toSearch;
	private SAMLInput samlInput;
	
	@Override
	public void run() {
		boolean queryError = false;
		//query this organization directly for patient matches
		List<PatientRecordDTO> searchResults = null;
		
		OrganizationDTO org = orgManager.getById(queryOrg.getOrgId());
		if(org == null) {
			logger.error("Could not find org with id " + queryOrg.getOrgId());
			return;
		}
		
		Adapter adapter = adapterFactory.getAdapter(org);
		if(adapter != null) {
			logger.info("Starting query to " + org.getAdapter() + " for orgStatus " + queryOrg.getId());
			try {
				searchResults = adapter.queryPatients(org, toSearch, samlInput);
				logger.info("Successfully queried " + org.getAdapter());
			} catch(Exception ex) {
				logger.error("Exception thrown in adapter " + adapter.getClass(), ex);
				queryError = true;
			}
		}
		//store the patients returned so we can retrieve them later when all orgs have finished querying
		if(searchResults != null && searchResults.size() > 0) {
			logger.info("Found " + searchResults.size() + " results for " + org.getAdapter());
			for(PatientRecordDTO patient : searchResults) {
				patient.setQueryOrganizationId(queryOrg.getId());
					
				//save the search results
				queryManager.addPatientRecord(patient);
				logger.info("Added patient record to the orgStatus " + queryOrg.getId());
			}
		} else {
			logger.info("Found 0 results for " + org.getAdapter());
		}
		
		synchronized(queryOrg.getQueryId()) {
			queryOrg.setStatus(queryError ? QueryOrganizationStatus.Failed : QueryOrganizationStatus.Success);
			queryOrg.setEndDate(new Date());
			queryManager.createOrUpdateQueryOrganization(queryOrg);
			queryManager.updateQueryStatusFromOrganizations(queryOrg.getQueryId());
		}
		logger.info("Completed query to " + org.getAdapter() + " for orgStatus" + queryOrg.getId());
	}

	public QueryOrganizationDTO getQueryOrg() {
		return queryOrg;
	}

	public void setQueryOrg(QueryOrganizationDTO queryOrg) {
		this.queryOrg = queryOrg;
	}

	public QueryManager getQueryManager() {
		return queryManager;
	}

	public void setQueryManager(QueryManager queryManager) {
		this.queryManager = queryManager;
	}

	public PatientManager getPatientManager() {
		return patientManager;
	}

	public void setPatientManager(PatientManager patientManager) {
		this.patientManager = patientManager;
	}

	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	public void setAdapterFactory(AdapterFactory adapterFactory) {
		this.adapterFactory = adapterFactory;
	}

	public PatientSearch getToSearch() {
		return toSearch;
	}

	public void setToSearch(PatientSearch toSearch) {
		this.toSearch = toSearch;
	}

	public OrganizationManager getOrgManager() {
		return orgManager;
	}

	public void setOrgManager(OrganizationManager orgManager) {
		this.orgManager = orgManager;
	}

	public SAMLInput getSamlInput() {
		return samlInput;
	}

	public void setSamlInput(SAMLInput samlInput) {
		this.samlInput = samlInput;
	}
}