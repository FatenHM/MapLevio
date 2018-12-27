package services;

import java.util.List;

import javax.ejb.Remote;

import model.Project;


@Remote
public interface ProjetRemote {

	public List<Project> testConsume();
	public int ajouterProject(Project p);
	public void deleteProjectById(int id);
	public int updateProject(int idProject,Project p);
	//public User getProjectByEmailAndPassword(String email, String password);
	public List<Project> getAllProjects();
}

