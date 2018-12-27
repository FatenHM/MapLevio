package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PreClients database table.
 * 
 */
@Entity
@Table(name="PreClients")
@NamedQuery(name="PreClient.findAll", query="SELECT p FROM PreClient p")
public class PreClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PreClientId")
	private int preClientId;

	@Column(name="Accepter")
	private boolean accepter;

	private int client_Type;
	
	@Column(name="Email")
	private String email;
	
	private String logo;
	
	@Column(name="Nom")
	private String nom;
	
	@Column(name="Password")
	private String password;

	//bi-directional many-to-one association to Organigram
	@ManyToOne
	@JoinColumn(name="Organigram_OrganigramId")
	private Organigram organigram;

	public PreClient() {
	}

	public int getPreClientId() {
		return this.preClientId;
	}

	public void setPreClientId(int preClientId) {
		this.preClientId = preClientId;
	}

	public boolean getAccepter() {
		return this.accepter;
	}

	public void setAccepter(boolean accepter) {
		this.accepter = accepter;
	}

	public int getClient_Type() {
		return this.client_Type;
	}

	public void setClient_Type(int client_Type) {
		this.client_Type = client_Type;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Organigram getOrganigram() {
		return this.organigram;
	}

	public void setOrganigram(Organigram organigram) {
		this.organigram = organigram;
	}

}