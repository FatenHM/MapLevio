package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the JobRequests database table.
 * 
 */
@Entity
@Table(name="JobRequests")
@NamedQuery(name="JobRequest.findAll", query="SELECT j FROM JobRequest j")
public class JobRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="JobRequestId")
	private int jobRequestId;

	private Timestamp date;

	private String specialite;

	private int state;

	//bi-directional many-to-one association to AspNetUser
	@OneToMany(mappedBy="jobRequest")
	private List<AspNetUser> aspNetUsers;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="idApplicant")
	private AspNetUser aspNetUser;

	public JobRequest() {
	}

	public int getJobRequestId() {
		return this.jobRequestId;
	}

	public void setJobRequestId(int jobRequestId) {
		this.jobRequestId = jobRequestId;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<AspNetUser> getAspNetUsers() {
		return this.aspNetUsers;
	}

	public void setAspNetUsers(List<AspNetUser> aspNetUsers) {
		this.aspNetUsers = aspNetUsers;
	}

	public AspNetUser addAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().add(aspNetUser);
		aspNetUser.setJobRequest(this);

		return aspNetUser;
	}

	public AspNetUser removeAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().remove(aspNetUser);
		aspNetUser.setJobRequest(null);

		return aspNetUser;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}