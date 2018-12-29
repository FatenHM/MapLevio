package managedBean;


import java.util.HashSet;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.AspNetUser;


@ManagedBean(name="conectedBean")
@ApplicationScoped
public class ConnectedUserBean {
	
	private Set<AspNetUser> users;
	
	@PostConstruct
	public void init() {
		setUsers(new HashSet<AspNetUser>()) ;
			
		}

	public Set<AspNetUser> getUsers() {
		return users;
	}

	public void setUsers(Set<AspNetUser> users) {
		this.users = users;
	}
	

}
