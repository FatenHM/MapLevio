package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Resources database table.
 * 
 */
@Entity
@Table(name="Resources")
@NamedQuery(name="Resource.findAll", query="SELECT r FROM Resource r")
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ResourceId")
	private int resourceId;

	private int contract;
	
	private String cv;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="First_name")
	private String first_name;
	
	private String lang;
	
	@Column(name="Last_name")
	private String last_name;
	
	private String lat;
	
	@Column(name="MandateId")
	private String mandateId;
	
	@Column(name="MprojectId")
	private String mprojectId;
	
	private String note;
	
	private String origine;
	
	private String picture;
	
	private String profile;
	
	private String sector;

	private int seniority;
	
	@Column(name="SkilsId")
	private String skilsId;

	private int state;

	//bi-directional many-to-one association to Mandate
	@OneToMany(mappedBy="resource")
	private List<Mandate> mandates;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="resource")
	private List<Message> messages;

	//bi-directional many-to-many association to Project
	@ManyToMany
	@JoinTable(
		name="ResourceProjects"
		, joinColumns={
			@JoinColumn(name="Resource_ResourceId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Project_ProjectId")
			}
		)
	private List<Project> projects;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="MyResourceManager_Id")
	private AspNetUser aspNetUser;

	//bi-directional many-to-one association to Organigram
	@ManyToOne
	@JoinColumn(name="myOrganigram_OrganigramId")
	private Organigram organigram;

	//bi-directional many-to-one association to Skil
	@OneToMany(mappedBy="resource")
	private List<Skil> skils;

	public Resource() {
	}

	public int getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getContract() {
		return this.contract;
	}

	public void setContract(int contract) {
		this.contract = contract;
	}

	public String getCv() {
		return this.cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return this.first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLang() {
		return this.lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getLast_name() {
		return this.last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getMandateId() {
		return this.mandateId;
	}

	public void setMandateId(String mandateId) {
		this.mandateId = mandateId;
	}

	public String getMprojectId() {
		return this.mprojectId;
	}

	public void setMprojectId(String mprojectId) {
		this.mprojectId = mprojectId;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOrigine() {
		return this.origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getProfile() {
		return this.profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public int getSeniority() {
		return this.seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public String getSkilsId() {
		return this.skilsId;
	}

	public void setSkilsId(String skilsId) {
		this.skilsId = skilsId;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<Mandate> getMandates() {
		return this.mandates;
	}

	public void setMandates(List<Mandate> mandates) {
		this.mandates = mandates;
	}

	public Mandate addMandate(Mandate mandate) {
		getMandates().add(mandate);
		mandate.setResource(this);

		return mandate;
	}

	public Mandate removeMandate(Mandate mandate) {
		getMandates().remove(mandate);
		mandate.setResource(null);

		return mandate;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setResource(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setResource(null);

		return message;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public Organigram getOrganigram() {
		return this.organigram;
	}

	public void setOrganigram(Organigram organigram) {
		this.organigram = organigram;
	}

	public List<Skil> getSkils() {
		return this.skils;
	}

	public void setSkils(List<Skil> skils) {
		this.skils = skils;
	}

	public Skil addSkil(Skil skil) {
		getSkils().add(skil);
		skil.setResource(this);

		return skil;
	}

	public Skil removeSkil(Skil skil) {
		getSkils().remove(skil);
		skil.setResource(null);

		return skil;
	}

}