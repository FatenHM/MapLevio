package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import model.Skil;

@Stateless
@LocalBean
public class SkilService implements SkilRemote{

	@PersistenceContext(unitName="MapLevio-ejb")

	EntityManager em;

	@Override
	public List<Skil> testConsume() {
		Client client = ClientBuilder.newClient();
		WebTarget target =client.target("http://localhost:8661/API/SkillsWS");
		Response reponse = target.request().get();
		System.out.println(reponse.readEntity(String.class));
		return null;
	}

	@Override
	public int ajouterSkil(Skil s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteSkilById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int updateSkil(int idSkil, Skil s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Skil> getAllSkils() {
		List<Skil> skil = em.createQuery("SELECT s FROM Skil s", Skil.class).getResultList();
		return skil;
	}
}
