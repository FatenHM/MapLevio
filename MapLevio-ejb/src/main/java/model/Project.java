package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Projects database table.
 * 
 */
@Entity
@Table(name="Projects")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProjectId")
	private int projectId;

	private Timestamp deb_Date;

	private Timestamp fin_Date;

	@Column(name="NbreRessources")
	private int nbreRessources;
	
	@Column(name="Nom")
	private String nom;

	private float prix;
	
	@Column(name="SkilsId")
	private String skilsId;

	private int type;

	//bi-directional many-to-one association to Mandate
	@OneToMany(mappedBy="project")
	private List<Mandate> mandates;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="idClient")
	private AspNetUser aspNetUser1;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="Client_Id")
	private AspNetUser aspNetUser2;

	//bi-directional many-to-one association to Organigram
	@ManyToOne
	@JoinColumn(name="myOrganigram_OrganigramId")
	private Organigram organigram;

	//bi-directional many-to-many association to Resource
	@ManyToMany(mappedBy="projects")
	private List<Resource> resources;

	//bi-directional many-to-one association to Skil
	@OneToMany(mappedBy="project")
	private List<Skil> skils;

	public Project() {
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Timestamp getDeb_Date() {
		return this.deb_Date;
	}

	public void setDeb_Date(Timestamp deb_Date) {
		this.deb_Date = deb_Date;
	}

	public Timestamp getFin_Date() {
		return this.fin_Date;
	}

	public void setFin_Date(Timestamp fin_Date) {
		this.fin_Date = fin_Date;
	}

	public int getNbreRessources() {
		return this.nbreRessources;
	}

	public void setNbreRessources(int nbreRessources) {
		this.nbreRessources = nbreRessources;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getSkilsId() {
		return this.skilsId;
	}

	public void setSkilsId(String skilsId) {
		this.skilsId = skilsId;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Mandate> getMandates() {
		return this.mandates;
	}

	public void setMandates(List<Mandate> mandates) {
		this.mandates = mandates;
	}

	public Mandate addMandate(Mandate mandate) {
		getMandates().add(mandate);
		mandate.setProject(this);

		return mandate;
	}

	public Mandate removeMandate(Mandate mandate) {
		getMandates().remove(mandate);
		mandate.setProject(null);

		return mandate;
	}

	public AspNetUser getAspNetUser1() {
		return this.aspNetUser1;
	}

	public void setAspNetUser1(AspNetUser aspNetUser1) {
		this.aspNetUser1 = aspNetUser1;
	}

	public AspNetUser getAspNetUser2() {
		return this.aspNetUser2;
	}

	public void setAspNetUser2(AspNetUser aspNetUser2) {
		this.aspNetUser2 = aspNetUser2;
	}

	public Organigram getOrganigram() {
		return this.organigram;
	}

	public void setOrganigram(Organigram organigram) {
		this.organigram = organigram;
	}

	public List<Resource> getResources() {
		return this.resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public List<Skil> getSkils() {
		return this.skils;
	}

	public void setSkils(List<Skil> skils) {
		this.skils = skils;
	}

	public Skil addSkil(Skil skil) {
		getSkils().add(skil);
		skil.setProject(this);

		return skil;
	}

	public Skil removeSkil(Skil skil) {
		getSkils().remove(skil);
		skil.setProject(null);

		return skil;
	}

}