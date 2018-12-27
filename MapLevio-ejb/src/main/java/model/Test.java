package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Tests database table.
 * 
 */
@Entity
@Table(name="Tests")
@NamedQuery(name="Test.findAll", query="SELECT t FROM Test t")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TestId")
	private int testId;

	private Timestamp date;

	private int stateTest;

	@Column(name="TestResult")
	private int testResult;

	private int testType;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="MyUser_Id")
	private AspNetUser aspNetUser;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="MyQuestions_Id")
	private Question question;

	public Test() {
	}

	public int getTestId() {
		return this.testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getStateTest() {
		return this.stateTest;
	}

	public void setStateTest(int stateTest) {
		this.stateTest = stateTest;
	}

	public int getTestResult() {
		return this.testResult;
	}

	public void setTestResult(int testResult) {
		this.testResult = testResult;
	}

	public int getTestType() {
		return this.testType;
	}

	public void setTestType(int testType) {
		this.testType = testType;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}