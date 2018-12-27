package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.AspNetUser;

@Stateless
@LocalBean
public class UserService implements UserServiceRemote {

	
	@PersistenceContext(unitName="MapLevio-ejb")

	EntityManager em;
	
	@Override
	public AspNetUser getuserBynameandPassword(String userName, String password) {
		TypedQuery<AspNetUser> query = em.createQuery("SELECT a FROM AspNetUser a WHERE a.userName =:userName and a.password =:password",
				AspNetUser.class);
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		AspNetUser user = null;
		try {
			user = (AspNetUser) query.getSingleResult();
		} catch (NoResultException  e) {
			System.out.println("Erreur : " + e);
		}
		return user;
	}

	@Override
	public void inscription(AspNetUser user) {
		em.persist(user);
	}
}



