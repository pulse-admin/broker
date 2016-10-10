package gov.ca.emsa.pulse.broker.dto;

import gov.ca.emsa.pulse.broker.entity.AlternateCareFacilityEntity;
import gov.ca.emsa.pulse.broker.entity.GivenNameEntity;
import gov.ca.emsa.pulse.broker.entity.PatientNameEntity;
import gov.ca.emsa.pulse.common.domain.GivenName;

import java.util.ArrayList;
import java.util.Date;

public class PatientNameDTO {

	private Long id;
	private ArrayList<GivenNameDTO> givenName;
	private String familyName;
	private String suffix;
	private String prefix;
	private String profSuffix;
	private String nameTypeCode;
	private String nameTypeCodeDescription;
	private String nameRepresentationCode;
	private String nameRepresentationCodeDescription;
	private String nameAssemblyOrderCode;
	private String nameAssemblyOrderCodeDescription;
	private Date effectiveDate;
	private Date expirationDate;

	public PatientNameDTO(){
		givenName = new ArrayList<GivenNameDTO>();
	}

	public PatientNameDTO(PatientNameEntity entity)
	{
		if(entity != null) {
			this.id = entity.getId();
			givenName = new ArrayList<GivenNameDTO>();
			for(GivenNameEntity givenName: entity.getGivenNames()){
				GivenNameDTO givenNameDTO = new GivenNameDTO(givenName);
				this.givenName.add(givenNameDTO);
			}
			this.familyName = entity.getFamilyName();
			if(entity.getSuffix() != null)
				this.suffix = entity.getSuffix();
			if(entity.getPrefix() != null)
				this.prefix = entity.getPrefix();
			if(entity.getNameTypeCode() != null)
				this.nameTypeCode = entity.getNameTypeCode();
			if(entity.getNameTypeCodeDescription() != null)
				this.nameTypeCodeDescription = entity.getNameTypeCodeDescription();
			if(entity.getNameRepresentationCode() != null)
				this.nameRepresentationCode = entity.getNameRepresentationCode();
			if(entity.getNameRepresentationCodeDescription() != null)
				this.nameRepresentationCodeDescription = entity.getNameRepresentationCodeDescription();
			if(entity.getNameAssemblyOrderCode() != null)
				this.nameAssemblyOrderCode = entity.getNameAssemblyOrderCode();
			if(entity.getNameAssemblyOrderCodeDescription() != null)
				this.nameAssemblyOrderCodeDescription = entity.getNameAssemblyOrderCodeDescription();
			if(entity.getEffectiveDate() != null)
				this.effectiveDate = entity.getEffectiveDate();
			if(entity.getExpirationDate() != null)
				this.expirationDate = entity.getExpirationDate();
		}
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ArrayList<GivenNameDTO> getGivenName() {
		return givenName;
	}
	public void setGivenName(ArrayList<GivenNameDTO> givenName) {
		this.givenName = givenName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getNameTypeCode() {
		return nameTypeCode;
	}
	public void setNameTypeCode(String nameTypeCode) {
		this.nameTypeCode = nameTypeCode;
	}
	public String getNameTypeCodeDescription() {
		return nameTypeCodeDescription;
	}
	public void setNameTypeCodeDescription(String nameTypeCodeDescription) {
		this.nameTypeCodeDescription = nameTypeCodeDescription;
	}
	public String getNameRepresentationCode() {
		return nameRepresentationCode;
	}
	public void setNameRepresentationCode(String nameRepresentationCode) {
		this.nameRepresentationCode = nameRepresentationCode;
	}
	public String getNameRepresentationCodeDescription() {
		return nameRepresentationCodeDescription;
	}
	public void setNameRepresentationCodeDescription(
			String nameRepresentationCodeDescription) {
		this.nameRepresentationCodeDescription = nameRepresentationCodeDescription;
	}
	public String getNameAssemblyOrderCode() {
		return nameAssemblyOrderCode;
	}
	public void setNameAssemblyOrderCode(String nameAssemblyOrderCode) {
		this.nameAssemblyOrderCode = nameAssemblyOrderCode;
	}
	public String getNameAssemblyOrderCodeDescription() {
		return nameAssemblyOrderCodeDescription;
	}
	public void setNameAssemblyOrderCodeDescription(
			String nameAssemblyOrderCodeDescription) {
		this.nameAssemblyOrderCodeDescription = nameAssemblyOrderCodeDescription;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getProfSuffix() {
		return profSuffix;
	}

	public void setProfSuffix(String profSuffix) {
		this.profSuffix = profSuffix;
	}

	
}
