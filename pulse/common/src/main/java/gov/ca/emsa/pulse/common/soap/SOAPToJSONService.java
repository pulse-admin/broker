package gov.ca.emsa.pulse.common.soap;

import ihe.iti.xds_b._2007.RetrieveDocumentSetRequestType;
import gov.ca.emsa.pulse.common.domain.DocumentQuery;
import gov.ca.emsa.pulse.common.domain.DocumentRetrieve;
import gov.ca.emsa.pulse.common.domain.Patient;
import gov.ca.emsa.pulse.common.domain.PatientRecord;
import gov.ca.emsa.pulse.common.domain.PatientSearch;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryRequest;

import java.util.List;

import org.hl7.v3.PRPAIN201305UV02;
import org.hl7.v3.PRPAIN201306UV02;

public interface SOAPToJSONService {
	public PatientSearch convertToPatientSearch(PRPAIN201305UV02 request);
	public List<PatientRecord> convertToPatientRecords(PRPAIN201306UV02 response);
	public List<Patient> convertToPatients(PRPAIN201306UV02 request);
	public DocumentQuery convertToDocumentQuery(AdhocQueryRequest request);
	public DocumentRetrieve convertToDocumentSetRequest(RetrieveDocumentSetRequestType request);
}