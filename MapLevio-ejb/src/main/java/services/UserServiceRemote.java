package services;

import javax.ejb.Remote;

import model.*;


@Remote
public interface UserServiceRemote {
	public AspNetUser getuserBynameandPassword(String username,String password);
	public void inscription(AspNetUser user);
}
