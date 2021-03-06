package managedBean;


import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Project;
import model.Resource;
import model.ResourceProject;
import services.DashboardService;
import services.DashboardServiceLocal;

@ManagedBean
@SessionScoped
public class DashboardBean {
	@EJB
	DashboardServiceLocal dashboardServiceLocal;
	
	private List<ResourceProject> resourceProjects = new ArrayList<ResourceProject>();
	private Integer test;
	public DashboardBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {

		setResourceProjects(prepareData(dashboardServiceLocal.getAll()));
		
	}

	public List<ResourceProject> getResourceProjects() {
		return resourceProjects;
	}

	public void setResourceProjects(List<ResourceProject> resourceProjects) {
		this.resourceProjects = resourceProjects;
	}
	
	public List<ResourceProject> prepareData(List<Resource> resources){
		List<ResourceProject> resourceProjects = new ArrayList<>();
		for (Resource resource : resources) {
			
			List<Project> projects=resource.getProjects();			
			for(Project project :projects){
				ResourceProject resourceProject = new  ResourceProject();
				resourceProject.setProject(project);
				resourceProject.setResource(resource);
				resourceProjects.add(resourceProject);
				
			}
		}
		return resourceProjects;
		
	}

	public Integer getTest() {
		return test;
	}

	public void setTest(Integer test) {
		this.test = test;
	}
	public String JsonWrite(){
		return null;

	}
	public Long nbrfreelancer(){
		return dashboardServiceLocal.getNumberFreelancers();
		
	}
	public Long nbrEmploye(){
		return dashboardServiceLocal.getNumberEmployees();
		
	}
	public Long nbrMandates(){
		return dashboardServiceLocal.getNumberEmployeesInMandates();
		
	}
	public Long nbrInterMandates(){
		return dashboardServiceLocal.getNumberEmployeesInterMandate();
		
	}

}
