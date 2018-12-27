package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Skils database table.
 * 
 */
@Entity
@Table(name="Skils")
@NamedQuery(name="Skil.findAll", query="SELECT s FROM Skil s")
public class Skil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SkilsId")
	private int skilsId;

	private String description_Skill;
	
	private String nameSkill;

	private float rate_Skill;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="Project_ProjectId")
	private Project project;

	//bi-directional many-to-one association to Resource
	@ManyToOne
	@JoinColumn(name="Resource_ResourceId")
	private Resource resource;

	public Skil() {
	}

	public int getSkilsId() {
		return this.skilsId;
	}

	public void setSkilsId(int skilsId) {
		this.skilsId = skilsId;
	}

	public String getDescription_Skill() {
		return this.description_Skill;
	}

	public void setDescription_Skill(String description_Skill) {
		this.description_Skill = description_Skill;
	}

	public String getNameSkill() {
		return this.nameSkill;
	}

	public void setNameSkill(String nameSkill) {
		this.nameSkill = nameSkill;
	}

	public float getRate_Skill() {
		return this.rate_Skill;
	}

	public void setRate_Skill(float rate_Skill) {
		this.rate_Skill = rate_Skill;
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