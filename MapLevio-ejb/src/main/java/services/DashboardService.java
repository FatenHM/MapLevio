package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Project;
import model.Resource;

@Stateless
public class DashboardService implements DashboardServiceRemote ,DashboardServiceLocal{
	@PersistenceContext(unitName="MapLevio-ejb")
	private EntityManager em;

	@Override
	public Long getNumberFreelancers() {
	/*	String sql = "SELECT COUNT(r.resourceId) FROM Resource r WHERE r.contract='Freelancer'";
		Query q = em.createQuery(sql);
		Long count =(Long) q.getSingleResult();
		return count;*/
		return null;
		
		
	}

	@Override
	public Long getNumberEmployees() {
		
		return null;
	}

	@Override
	public Long getNumberEmployeesInMandates() {
		
		return null;
	}

	@Override
	public Long getNumberEmployeesInterMandate() {
		
		return null;
	}

	@Override
	public Long getNumberEmployeesAdministration() {
		
		return null;
	}

	@Override
	public void reportResource(int ressourceId) {
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Resource", Resource.class).getResultList();	
	}
}
