package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Questions database table.
 * 
 */
@Entity
@Table(name="Questions")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Q1")
	private String q1;
	
	@Column(name="Q2")
	private String q2;
	
	@Column(name="Q3")
	private String q3;
	
	@Column(name="Q4")
	private String q4;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="question")
	private List<Test> tests;

	public Question() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQ1() {
		return this.q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}

	public String getQ2() {
		return this.q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	public String getQ3() {
		return this.q3;
	}

	public void setQ3(String q3) {
		this.q3 = q3;
	}

	public String getQ4() {
		return this.q4;
	}

	public void setQ4(String q4) {
		this.q4 = q4;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setQuestion(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setQuestion(null);

		return test;
	}

}