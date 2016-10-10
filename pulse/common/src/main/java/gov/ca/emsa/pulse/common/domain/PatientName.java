package gov.ca.emsa.pulse.common.domain;

import java.util.ArrayList;
import java.util.Date;

public class PatientName {
	
	private String id;
	private ArrayList<GivenName> givens;
	private String family;
	private String suffix;
	private String prefix;
	private String profSuffix;
	private String nameType;
	private String nameTypeCodeDescription;
	private String nameRepresentationCode;
	private String nameRepresentationCodeDescription;
	private String nameAssemblyOrderCode;
	private String nameAssemblyOrderCodeDescription;
	private Date effectiveDate;
	private Date expirationDate;
	
	public PatientName(){
		this.givens = new ArrayList<GivenName>();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<GivenName> getGivenName() {
		return givens;
	}
	public void setGivenName(ArrayList<GivenName> givens) {
		this.givens = givens;
	}
	public String getFamilyName() {
		return family;
	}
	public void setFamilyName(String familyName) {
		this.family = familyName;
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
	public String getNameType() {
		return nameType;
	}
	public void setNameTypeCode(String nameType) {
		this.nameType = nameType;
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
