package managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.AspNetUser;
import services.UserService;

@ManagedBean
@ApplicationScoped
public class inscriptionBean implements Serializable{
	private static final long serialVersionUID= 1L;

	private AspNetUser user;
	private String password;
	private String userName;
    private String discriminator;
    private String email;
    
    
    @EJB
	UserService usersevice;
    public List<String>roles;
	  

    public void inscription(){
    	AspNetUser user =new AspNetUser();
    	user.setDiscriminator(discriminator);
    	user.setEmail(email);
    	user.setPassword(password);
    	user.setUserName(userName);
   
    	usersevice.inscription(new AspNetUser(discriminator,email,password,userName));
    }
		
    
		
			
		 
		//	mat=agriculteur.getMatricule();
			
	
	public List<String> getAllRoles() {
		roles=new ArrayList<String>();
		  roles.add("Client");
		  roles.add("Resource");
		return roles;
	}


	public void setAllRoles(List<String> roles) {
		this.roles = roles;
	}


	public AspNetUser getUser() {
		return user;
	}


	public void setUser(AspNetUser user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getDiscriminator() {
		return discriminator;
	}


	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public UserService getUsersevice() {
		return usersevice;
	}


	public void setUsersevice(UserService usersevice) {
		this.usersevice = usersevice;
	}
    
    
    
    
}
