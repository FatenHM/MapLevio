package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Contract;
import model.Project;
import model.Resource;
import model.State;


@Stateless
public class DashboardService implements DashboardServiceRemote, DashboardServiceLocal {
	@PersistenceContext(unitName = "MapLevio-ejb")
	private EntityManager em;

	@Override
	public Long getNumberFreelancers() {
		Contract contarct = Contract.Freelancer;
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(r) FROM Resource AS r  WHERE r.contract=:freelancer",
				Long.class);
		
		
		return query.setParameter("freelancer", contarct).getSingleResult();

	}

	@Override
	public Long getNumberEmployees() {
		Contract contarct = Contract.Employer;
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(r) FROM Resource r  WHERE r.contract= :Employer",
				Long.class);

		return query.setParameter("Employer", contarct).getSingleResult();

	}

	@Override
	public Long getNumberEmployeesInMandates() {
				
		TypedQuery<Long> query = em.createQuery(
				"SELECT COUNT(r) FROM Resource r  WHERE r.contract= :Employer AND r.state= :notAvailable or r.state= :soonavailable",
				Long.class);

		
		return query.setParameter("Employer",Contract.Employer).setParameter("notAvailable",State.notAvailable).setParameter("soonavailable", State.soonavailable).getSingleResult();
	}

	@Override
	public Long getNumberEmployeesInterMandate() {
		TypedQuery<Long> query = em.createQuery(
				"SELECT COUNT(r) FROM Resource r  WHERE r.contract= :Employer AND r.state= :available",
				Long.class);

		return query.setParameter("Employer",Contract.Employer).setParameter("available", State.available).getSingleResult();
	}

	


	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Resource", Resource.class).getResultList();
	}
}
