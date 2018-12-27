package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Mandates database table.
 * 
 */
@Entity
@Table(name="Mandates")
@NamedQuery(name="Mandate.findAll", query="SELECT m FROM Mandate m")
public class Mandate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MandateId")
	private int mandateId;
	
	@Column(name="Discriminator")
	private String discriminator;

	private Timestamp endDate;

	private float fee;

	private Timestamp startDate;

	//bi-directional many-to-one association to MandateHistory
	@ManyToOne
	@JoinColumn(name="MyHistory_MandateHistoryId")
	private MandateHistory mandateHistory;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="myProject_ProjectId")
	private Project project;

	//bi-directional many-to-one association to Resource
	@ManyToOne
	@JoinColumn(name="Resource_ResourceId")
	private Resource resource;

	public Mandate() {
	}

	public int getMandateId() {
		return this.mandateId;
	}

	public void setMandateId(int mandateId) {
		this.mandateId = mandateId;
	}

	public String getDiscriminator() {
		return this.discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public float getFee() {
		return this.fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public MandateHistory getMandateHistory() {
		return this.mandateHistory;
	}

	public void setMandateHistory(MandateHistory mandateHistory) {
		this.mandateHistory = mandateHistory;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}