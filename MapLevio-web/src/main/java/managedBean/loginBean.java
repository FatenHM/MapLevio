package managedBean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.AspNetUser;
import services.UserService;


@ManagedBean
@ApplicationScoped
public class loginBean {
	
	private AspNetUser user;
	private String password;
	private String userName;
	private boolean loggedIn;
	@EJB
	UserService usersevice;
	
	
	
	
	
	public String doLogin(){
		String navigateTo="null";
		user=usersevice.getuserBynameandPassword(userName, password);
		System.out.println("ok1");
		if(user!=null & user.getDiscriminator().equals("Client")){ 
			System.out.println("ok2");
			navigateTo="index?faces-redirect=true"; 
		
			loggedIn=true;
		
			
		 
		//	mat=agriculteur.getMatricule();
			
		}
		else if(user!=null & user.getDiscriminator().equals("Administration")){
		 System.out.println("ok3");
			navigateTo="/Template/template?faces-redirect=true";
			loggedIn=true;
			
		 
		
			
		}
		else{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credentials"));
		}
	return navigateTo;
	}
	
	

	public String doLogout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login?faces-redirect=true";
	}
	
	
	
	
	
	
	
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
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

	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public UserService getUsersevice() {
		return usersevice;
	}
	public void setUsersevice(UserService usersevice) {
		this.usersevice = usersevice;
	} 
	
	
	
	
}
