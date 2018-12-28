package services;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Project;

@Stateless
@LocalBean
public class ProjetService implements ProjetRemote{

	@PersistenceContext(unitName = "MapLevio-ejb")
	EntityManager em;
	
	
	
	@Override
	public List<Project> testConsume() {
		Client client = ClientBuilder.newClient();
		WebTarget target =client.target("http://localhost:8661/api/ProjetWS");
		Response reponse = target.request().get();
		System.out.println(reponse.readEntity(String.class));
		return null;
	}

	@Override
	public int ajouterProject(Project p) {
		Client client = ClientBuilder.newClient();
		WebTarget target =client.target("http://localhost:22033/Restfull/CreateQuestion");
		Invocation.Builder invocationBuilder=target.request(MediaType.APPLICATION_JSON);
		//Response reponse = target.request().get();
		Response response =invocationBuilder.post(Entity.entity(p, MediaType.APPLICATION_JSON));
		System.out.println(response.readEntity(String.class));
		return 0;
	}

	@Override
	public void deleteProjectById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int updateProject(int idProject, Project p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> emp = em.createQuery("SELECT p FROM Project p", Project.class).getResultList();
		return emp;
	
		
	}

	

}
