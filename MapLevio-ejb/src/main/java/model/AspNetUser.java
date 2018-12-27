package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the AspNetUsers database table.
 * 
 */
@Entity
@Table(name="AspNetUsers")
@NamedQuery(name="AspNetUser.findAll", query="SELECT a FROM AspNetUser a")
public class AspNetUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private String id;

	@Column(name="Accepter")
	private boolean accepter;

	@Column(name="AccessFailedCount")
	private int accessFailedCount;

	@Column(name="client_type")
	private int clientType;

	@Column(name="Discriminator")
	
	private String discriminator;
	
	@Column(name="Email")
	private String email;

	@Column(name="EmailConfirmed")
	private boolean emailConfirmed;

	@Column(name="LockoutEnabled")
	private boolean lockoutEnabled;

	@Column(name="LockoutEndDateUtc")
	private Timestamp lockoutEndDateUtc;
	
	private String logo;
	
	private String name;
	
	private String password;
	
	@Column(name="PasswordHash")
	private String passwordHash;
	
	@Column(name="PhoneNumber")
	private String phoneNumber;

	@Column(name="PhoneNumberConfirmed")
	private boolean phoneNumberConfirmed;
	
	@Column(name="SecurityStamp")
	private String securityStamp;
	
	private String surname;

	@Column(name="TwoFactorEnabled")
	private boolean twoFactorEnabled;
	
	@Column(name="UserName")
	private String userName;

	//bi-directional many-to-one association to AspNetUserClaim
	@OneToMany(mappedBy="aspNetUser")
	private List<AspNetUserClaim> aspNetUserClaims;

	//bi-directional many-to-one association to AspNetUserLogin
	@OneToMany(mappedBy="aspNetUser")
	private List<AspNetUserLogin> aspNetUserLogins;

	//bi-directional many-to-many association to AspNetRole
	@ManyToMany
	@JoinTable(
		name="AspNetUserRoles"
		, joinColumns={
			@JoinColumn(name="UserId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="RoleId")
			}
		)
	private List<AspNetRole> aspNetRoles;

	//bi-directional many-to-one association to JobRequest
	@ManyToOne
	@JoinColumn(name="MyJobRequest_JobRequestId")
	private JobRequest jobRequest;

	//bi-directional many-to-one association to ResourceRequest
	@ManyToOne
	@JoinColumn(name="MyResourceRequestes_ResourceRequestId")
	private ResourceRequest resourceRequest;

	//bi-directional many-to-one association to JobRequest
	@OneToMany(mappedBy="aspNetUser")
	private List<JobRequest> jobRequests;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="aspNetUser1")
	private List<Message> messages1;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="aspNetUser2")
	private List<Message> messages2;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="aspNetUser3")
	private List<Message> messages3;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="aspNetUser1")
	private List<Project> projects1;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="aspNetUser2")
	private List<Project> projects2;

	//bi-directional many-to-one association to ResourceRequest
	@OneToMany(mappedBy="aspNetUser")
	private List<ResourceRequest> resourceRequests;

	//bi-directional many-to-one association to Resource
	@OneToMany(mappedBy="aspNetUser")
	private List<Resource> resources;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="aspNetUser")
	private List<Test> tests;

	public AspNetUser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getAccepter() {
		return this.accepter;
	}

	public void setAccepter(boolean accepter) {
		this.accepter = accepter;
	}

	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	public int getClientType() {
		return this.clientType;
	}

	public void setClientType(int clientType) {
		this.clientType = clientType;
	}

	public String getDiscriminator() {
		return this.discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public boolean getLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	public Timestamp getLockoutEndDateUtc() {
		return this.lockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(Timestamp lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean getPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}

	public String getSecurityStamp() {
		return this.securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<AspNetUserClaim> getAspNetUserClaims() {
		return this.aspNetUserClaims;
	}

	public void setAspNetUserClaims(List<AspNetUserClaim> aspNetUserClaims) {
		this.aspNetUserClaims = aspNetUserClaims;
	}

	public AspNetUserClaim addAspNetUserClaim(AspNetUserClaim aspNetUserClaim) {
		getAspNetUserClaims().add(aspNetUserClaim);
		aspNetUserClaim.setAspNetUser(this);

		return aspNetUserClaim;
	}

	public AspNetUserClaim removeAspNetUserClaim(AspNetUserClaim aspNetUserClaim) {
		getAspNetUserClaims().remove(aspNetUserClaim);
		aspNetUserClaim.setAspNetUser(null);

		return aspNetUserClaim;
	}

	public List<AspNetUserLogin> getAspNetUserLogins() {
		return this.aspNetUserLogins;
	}

	public void setAspNetUserLogins(List<AspNetUserLogin> aspNetUserLogins) {
		this.aspNetUserLogins = aspNetUserLogins;
	}

	public AspNetUserLogin addAspNetUserLogin(AspNetUserLogin aspNetUserLogin) {
		getAspNetUserLogins().add(aspNetUserLogin);
		aspNetUserLogin.setAspNetUser(this);

		return aspNetUserLogin;
	}

	public AspNetUserLogin removeAspNetUserLogin(AspNetUserLogin aspNetUserLogin) {
		getAspNetUserLogins().remove(aspNetUserLogin);
		aspNetUserLogin.setAspNetUser(null);

		return aspNetUserLogin;
	}

	public List<AspNetRole> getAspNetRoles() {
		return this.aspNetRoles;
	}

	public void setAspNetRoles(List<AspNetRole> aspNetRoles) {
		this.aspNetRoles = aspNetRoles;
	}

	public JobRequest getJobRequest() {
		return this.jobRequest;
	}

	public void setJobRequest(JobRequest jobRequest) {
		this.jobRequest = jobRequest;
	}

	public ResourceRequest getResourceRequest() {
		return this.resourceRequest;
	}

	public void setResourceRequest(ResourceRequest resourceRequest) {
		this.resourceRequest = resourceRequest;
	}

	public List<JobRequest> getJobRequests() {
		return this.jobRequests;
	}

	public void setJobRequests(List<JobRequest> jobRequests) {
		this.jobRequests = jobRequests;
	}

	public JobRequest addJobRequest(JobRequest jobRequest) {
		getJobRequests().add(jobRequest);
		jobRequest.setAspNetUser(this);

		return jobRequest;
	}

	public JobRequest removeJobRequest(JobRequest jobRequest) {
		getJobRequests().remove(jobRequest);
		jobRequest.setAspNetUser(null);

		return jobRequest;
	}

	public List<Message> getMessages1() {
		return this.messages1;
	}

	public void setMessages1(List<Message> messages1) {
		this.messages1 = messages1;
	}

	public Message addMessages1(Message messages1) {
		getMessages1().add(messages1);
		messages1.setAspNetUser1(this);

		return messages1;
	}

	public Message removeMessages1(Message messages1) {
		getMessages1().remove(messages1);
		messages1.setAspNetUser1(null);

		return messages1;
	}

	public List<Message> getMessages2() {
		return this.messages2;
	}

	public void setMessages2(List<Message> messages2) {
		this.messages2 = messages2;
	}

	public Message addMessages2(Message messages2) {
		getMessages2().add(messages2);
		messages2.setAspNetUser2(this);

		return messages2;
	}

	public Message removeMessages2(Message messages2) {
		getMessages2().remove(messages2);
		messages2.setAspNetUser2(null);

		return messages2;
	}

	public List<Message> getMessages3() {
		return this.messages3;
	}

	public void setMessages3(List<Message> messages3) {
		this.messages3 = messages3;
	}

	public Message addMessages3(Message messages3) {
		getMessages3().add(messages3);
		messages3.setAspNetUser3(this);

		return messages3;
	}

	public Message removeMessages3(Message messages3) {
		getMessages3().remove(messages3);
		messages3.setAspNetUser3(null);

		return messages3;
	}

	public List<Project> getProjects1() {
		return this.projects1;
	}

	public void setProjects1(List<Project> projects1) {
		this.projects1 = projects1;
	}

	public Project addProjects1(Project projects1) {
		getProjects1().add(projects1);
		projects1.setAspNetUser1(this);

		return projects1;
	}

	public Project removeProjects1(Project projects1) {
		getProjects1().remove(projects1);
		projects1.setAspNetUser1(null);

		return projects1;
	}

	public List<Project> getProjects2() {
		return this.projects2;
	}

	public void setProjects2(List<Project> projects2) {
		this.projects2 = projects2;
	}

	public Project addProjects2(Project projects2) {
		getProjects2().add(projects2);
		projects2.setAspNetUser2(this);

		return projects2;
	}

	public Project removeProjects2(Project projects2) {
		getProjects2().remove(projects2);
		projects2.setAspNetUser2(null);

		return projects2;
	}

	public List<ResourceRequest> getResourceRequests() {
		return this.resourceRequests;
	}

	public void setResourceRequests(List<ResourceRequest> resourceRequests) {
		this.resourceRequests = resourceRequests;
	}

	public ResourceRequest addResourceRequest(ResourceRequest resourceRequest) {
		getResourceRequests().add(resourceRequest);
		resourceRequest.setAspNetUser(this);

		return resourceRequest;
	}

	public ResourceRequest removeResourceRequest(ResourceRequest resourceRequest) {
		getResourceRequests().remove(resourceRequest);
		resourceRequest.setAspNetUser(null);

		return resourceRequest;
	}

	public List<Resource> getResources() {
		return this.resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public Resource addResource(Resource resource) {
		getResources().add(resource);
		resource.setAspNetUser(this);

		return resource;
	}

	public Resource removeResource(Resource resource) {
		getResources().remove(resource);
		resource.setAspNetUser(null);

		return resource;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setAspNetUser(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setAspNetUser(null);

		return test;
	}

	public AspNetUser(String discriminator, String email, String password, String userName) {
		super();
		this.discriminator = discriminator;
		this.email = email;
		this.password = password;
		this.userName = userName;
	}
	

}