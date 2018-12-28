package services;

import java.util.List;

import javax.ejb.Remote;

import model.Skil;


@Remote
public interface SkilRemote {

	public List<Skil> testConsume();
	public int ajouterSkil(Skil s);
	public void deleteSkilById(int id);
	public int updateSkil(int idSkil,Skil s);
	
	public List<Skil> getAllSkils();
}
