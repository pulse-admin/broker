package gov.ca.emsa.pulse.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.opensaml.xml.io.MarshallingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import gov.ca.emsa.pulse.broker.domain.Patient;
import gov.ca.emsa.pulse.broker.domain.Query;
import gov.ca.emsa.pulse.broker.dto.DtoToDomainConverter;
import gov.ca.emsa.pulse.broker.dto.PatientDTO;
import gov.ca.emsa.pulse.broker.dto.QueryDTO;
import gov.ca.emsa.pulse.broker.manager.PatientManager;
import gov.ca.emsa.pulse.broker.saml.SAMLInput;
import gov.ca.emsa.pulse.broker.saml.SamlGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "patients")
@RestController
@RequestMapping("/patients")
public class PatientService {
	@Autowired PatientManager patientManager;
	@Autowired SamlGenerator samlGenerator;
	
	@ApiOperation(value="Query all organizations for patients. This runs asynchronously and returns a query object"
			+ "which can later be used to get the results.")
	@RequestMapping("")
    public Query searchPatients(
    		@RequestParam(value="firstName", defaultValue="") String firstName,
    		@RequestParam(value="lastName", defaultValue="") String lastName) throws JsonProcessingException {
		SAMLInput input = new SAMLInput();
		input.setStrIssuer("https://idp.dhv.gov");
		input.setStrNameID("UserBrianLindsey");
		input.setStrNameQualifier("My Website");
		input.setSessionId("abcdedf1234567");
		
		
		HashMap<String, String> customAttributes = new HashMap<String,String>();
		customAttributes.put("RequesterFirstName", "John");
		customAttributes.put("RequesterLastName", "Smith");
		customAttributes.put("RequestReason", "Patient is bleeding.");
		customAttributes.put("PatientFirstName", firstName);
		customAttributes.put("PatientLastName", lastName);
		customAttributes.put("PatientSSN", "123456789");
		
		input.setAttributes(customAttributes);
		
		String samlMessage = null;
		
		try {
			samlMessage = samlGenerator.createSAML(input);
		} catch (MarshallingException e) {
			e.printStackTrace();
		}
		
       QueryDTO initiatedQuery = patientManager.queryPatients(samlMessage, firstName, lastName);
       return new Query(initiatedQuery);
    }
		
	@ApiOperation(value="Get the stored results of the query")
	@RequestMapping("/query/{queryId}")
	public List<Patient> getPatientsForQuery(@PathVariable("queryId") Long queryId) {
		List<PatientDTO> queryResults = patientManager.getPatientsByQuery(queryId);
		List<Patient> results = new ArrayList<Patient>(queryResults.size());
        for(PatientDTO qr : queryResults) {
        	Patient pat = DtoToDomainConverter.convert(qr);
        	results.add(pat);
        }
        
        return results;
	}
}