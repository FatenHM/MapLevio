package managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import model.Project;
import model.Resource;
import model.Skil;
import services.SkilService;

@ManagedBean(name="skilBean")
@SessionScoped
public class skillsBean implements Serializable {
	@EJB
	SkilService skilService;
	List<Skil>Skils;
	private int skilsId;

	private String description_Skill;
	
	private String nameSkill;

	private float rate_Skill;

	private Resource resource;


	public List<Skil> getsk() {
	return skilService.getAllSkils();
		
	}


	public void setSkils(List<Skil> skils) {
		this.Skils = skils;
	}


	public int getSkilsId() {
		return skilsId;
	}


	public void setSkilsId(int skilsId) {
		this.skilsId = skilsId;
	}


	public String getDescription_Skill() {
		return description_Skill;
	}


	public void setDescription_Skill(String description_Skill) {
		this.description_Skill = description_Skill;
	}


	public String getNameSkill() {
		return nameSkill;
	}


	public void setNameSkill(String nameSkill) {
		this.nameSkill = nameSkill;
	}


	public float getRate_Skill() {
		return rate_Skill;
	}


	public void setRate_Skill(float rate_Skill) {
		this.rate_Skill = rate_Skill;
	}



	public Resource getResource() {
		return resource;
	}


	public void setResource(Resource resource) {
		this.resource = resource;
	}

	

}
