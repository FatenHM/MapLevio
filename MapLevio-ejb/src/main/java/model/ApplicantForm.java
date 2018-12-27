package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ApplicantForms database table.
 * 
 */
@Entity
@Table(name="ApplicantForms")
@NamedQuery(name="ApplicantForm.findAll", query="SELECT a FROM ApplicantForm a")
public class ApplicantForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ApplicantFormId")
	private int applicantFormId;
	
	private String testResult;

	public ApplicantForm() {
	}

	public int getApplicantFormId() {
		return this.applicantFormId;
	}

	public void setApplicantFormId(int applicantFormId) {
		this.applicantFormId = applicantFormId;
	}

	public String getTestResult() {
		return this.testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

}