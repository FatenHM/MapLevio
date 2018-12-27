package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Organigrams database table.
 * 
 */
@Entity
@Table(name="Organigrams")
@NamedQuery(name="Organigram.findAll", query="SELECT o FROM Organigram o")
public class Organigram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OrganigramId")
	private int organigramId;
	
	private String nomDirecteur;
	
	private String nomhautDirecteur;

	@Column(name="PreClientId")
	private int preClientId;
	
	@Column(name="Pvp")
	private String pvp;
	
	@Column(name="Vp")
	private String vp;

	//bi-directional many-to-one association to PreClient
	@OneToMany(mappedBy="organigram")
	private List<PreClient> preClients;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="organigram")
	private List<Project> projects;

	//bi-directional many-to-one association to Resource
	@OneToMany(mappedBy="organigram")
	private List<Resource> resources;

	public Organigram() {
	}

	public int getOrganigramId() {
		return this.organigramId;
	}

	public void setOrganigramId(int organigramId) {
		this.organigramId = organigramId;
	}

	public String getNomDirecteur() {
		return this.nomDirecteur;
	}

	public void setNomDirecteur(String nomDirecteur) {
		this.nomDirecteur = nomDirecteur;
	}

	public String getNomhautDirecteur() {
		return this.nomhautDirecteur;
	}

	public void setNomhautDirecteur(String nomhautDirecteur) {
		this.nomhautDirecteur = nomhautDirecteur;
	}

	public int getPreClientId() {
		return this.preClientId;
	}

	public void setPreClientId(int preClientId) {
		this.preClientId = preClientId;
	}

	public String getPvp() {
		return this.pvp;
	}

	public void setPvp(String pvp) {
		this.pvp = pvp;
	}

	public String getVp() {
		return this.vp;
	}

	public void setVp(String vp) {
		this.vp = vp;
	}

	public List<PreClient> getPreClients() {
		return this.preClients;
	}

	public void setPreClients(List<PreClient> preClients) {
		this.preClients = preClients;
	}

	public PreClient addPreClient(PreClient preClient) {
		getPreClients().add(preClient);
		preClient.setOrganigram(this);

		return preClient;
	}

	public PreClient removePreClient(PreClient preClient) {
		getPreClients().remove(preClient);
		preClient.setOrganigram(null);

		return preClient;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setOrganigram(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setOrganigram(null);

		return project;
	}

	public List<Resource> getResources() {
		return this.resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public Resource addResource(Resource resource) {
		getResources().add(resource);
		resource.setOrganigram(this);

		return resource;
	}

	public Resource removeResource(Resource resource) {
		getResources().remove(resource);
		resource.setOrganigram(null);

		return resource;
	}

}