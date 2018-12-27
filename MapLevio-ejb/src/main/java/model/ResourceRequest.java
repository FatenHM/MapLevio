package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ResourceRequests database table.
 * 
 */
@Entity
@Table(name="ResourceRequests")
@NamedQuery(name="ResourceRequest.findAll", query="SELECT r FROM ResourceRequest r")
public class ResourceRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ResourceRequestId")
	private String resourceRequestId;

	private float coast;
	
	@Column(name="Duration")
	private String duration;
	
	private String project;
	
	private String resourceType;

	@Column(name="state_type")
	private int stateType;

	//bi-directional many-to-one association to AspNetUser
	@OneToMany(mappedBy="resourceRequest")
	private List<AspNetUser> aspNetUsers;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="clientRRId")
	private AspNetUser aspNetUser;

	public ResourceRequest() {
	}

	public String getResourceRequestId() {
		return this.resourceRequestId;
	}

	public void setResourceRequestId(String resourceRequestId) {
		this.resourceRequestId = resourceRequestId;
	}

	public float getCoast() {
		return this.coast;
	}

	public void setCoast(float coast) {
		this.coast = coast;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public int getStateType() {
		return this.stateType;
	}

	public void setStateType(int stateType) {
		this.stateType = stateType;
	}

	public List<AspNetUser> getAspNetUsers() {
		return this.aspNetUsers;
	}

	public void setAspNetUsers(List<AspNetUser> aspNetUsers) {
		this.aspNetUsers = aspNetUsers;
	}

	public AspNetUser addAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().add(aspNetUser);
		aspNetUser.setResourceRequest(this);

		return aspNetUser;
	}

	public AspNetUser removeAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().remove(aspNetUser);
		aspNetUser.setResourceRequest(null);

		return aspNetUser;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}