package gov.ca.emsa.pulse.xcpd;

import javax.xml.bind.annotation.XmlAttribute;

public class Custodian {
	@XmlAttribute private String typeCode;
	private AssingedEntity ae;

	public Custodian() {
	}

	public AssingedEntity getAe() {
		return ae;
	}

	public void setAe(AssingedEntity ae) {
		this.ae = ae;
	}
}