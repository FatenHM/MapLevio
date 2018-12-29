package services;

import java.util.List;

import javax.ejb.Remote;
import model.Resource;

@Remote
public interface DashboardServiceRemote {
	public List<Resource> getAll();
	public Long getNumberFreelancers() ;
	public Long getNumberEmployees();
	public Long getNumberEmployeesInMandates();
	public Long getNumberEmployeesInterMandate();
	public Long getNumberEmployeesAdministration() ;
	public void reportResource(int ressourceId) ;
}
