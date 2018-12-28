package managedBean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import model.AspNetUser;
import model.Project;
import services.ProjetService;

@ManagedBean(name="projectBean")
@SessionScoped
public class projectBean implements Serializable{
	private static final long serialVersionUID= 1L;
	
	


	
	
	private int projectId;
	private Timestamp deb_Date;
	private Timestamp fin_Date;
	private int nbreRessources;
    private String nom;
	private float prix;
	private String skilsId;
    private int type;
	private AspNetUser aspNetUser1;
    @EJB
	ProjetService ProjectService; 
    
    List<Project> projects ;
    private Project project; 
    Project projectAjout=new Project();
    
    public void addProjet() throws ParseException {
    	Project projectAjout=new Project();
    	projectAjout.setNom(nom);
    	projectAjout.setDeb_Date(deb_Date);
    	projectAjout.setFin_Date(fin_Date);
    	projectAjout.setNbreRessources(nbreRessources);

    	
    	
    	
    	
    	
    	
    	
    	/*projectAjout.setSkilsId(skilsId);
    	projectAjout.setType(type);
    	projectAjout.setAspNetUser1(aspNetUser1);*/
    	
    	int response=ProjectService.ajouterProject(projectAjout); }
    
    
  



	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public AspNetUser getAspNetUser1() {
		return aspNetUser1;
	}
	public void setAspNetUser1(AspNetUser aspNetUser1) {
		this.aspNetUser1 = aspNetUser1;
	}
	public Timestamp getDeb_Date() {
		return deb_Date;
	}
	public void setDeb_Date(Timestamp deb_Date) {
		this.deb_Date = deb_Date;
	}
	public Timestamp getFin_Date() {
		return fin_Date;
	}
	public void setFin_Date(Timestamp fin_Date) {
		this.fin_Date = fin_Date;
	}
	public int getNbreRessources() {
		return nbreRessources;
	}
	public void setNbreRessources(int nbreRessources) {
		this.nbreRessources = nbreRessources;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getSkilsId() {
		return skilsId;
	}
	public void setSkilsId(String skilsId) {
		this.skilsId = skilsId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	/*public List<Project> getProj() {
		projects = ProjectService.getAllProjects(); 
		return projects;
	}*/

	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Project getProjectAjout() {
		return projectAjout;
	}
	public void setProjectAjout(Project projectAjout) {
		this.projectAjout = projectAjout;
	}






	public List<Project> getPro() {
		projects = ProjectService.getAllProjects();
		return projects;
	}






	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
    
    

}
