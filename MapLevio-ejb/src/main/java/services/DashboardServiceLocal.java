package services;

import java.util.List;

import javax.ejb.Local;

import model.Resource;

@Local
public interface DashboardServiceLocal {
	public List<Resource> getAll();
	public Long getNumberFreelancers() ;
	public Long getNumberEmployees();
	public Long getNumberEmployeesInMandates();
	public Long getNumberEmployeesInterMandate();
	
	

}
