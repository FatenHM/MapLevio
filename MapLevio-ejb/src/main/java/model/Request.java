package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Requests database table.
 * 
 */
@Entity
@Table(name="Requests")
@NamedQuery(name="Request.findAll", query="SELECT r FROM Request r")
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RequestId")
	private int requestId;
	
	private String competence;

	private double cout;

	@Column(name="debut_mandat")
	private Timestamp debutMandat;
	
	@Column(name="description_projet")
	private String descriptionProjet;
	
	private String duree;

	@Column(name="fin_mandat")
	private Timestamp finMandat;

	@Column(name="nbre_ressource")
	private int nbreRessource;
	
	@Column(name="nom_projet")
	private String nomProjet;
	
	@Column(name="nom_responsable")
	private String nomResponsable;

	@Column(name="request_type")
	private int requestType;

	public Request() {
	}

	public int getRequestId() {
		return this.requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getCompetence() {
		return this.competence;
	}

	public void setCompetence(String competence) {
		this.competence = competence;
	}

	public double getCout() {
		return this.cout;
	}

	public void setCout(double cout) {
		this.cout = cout;
	}

	public Timestamp getDebutMandat() {
		return this.debutMandat;
	}

	public void setDebutMandat(Timestamp debutMandat) {
		this.debutMandat = debutMandat;
	}

	public String getDescriptionProjet() {
		return this.descriptionProjet;
	}

	public void setDescriptionProjet(String descriptionProjet) {
		this.descriptionProjet = descriptionProjet;
	}

	public String getDuree() {
		return this.duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public Timestamp getFinMandat() {
		return this.finMandat;
	}

	public void setFinMandat(Timestamp finMandat) {
		this.finMandat = finMandat;
	}

	public int getNbreRessource() {
		return this.nbreRessource;
	}

	public void setNbreRessource(int nbreRessource) {
		this.nbreRessource = nbreRessource;
	}

	public String getNomProjet() {
		return this.nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public String getNomResponsable() {
		return this.nomResponsable;
	}

	public void setNomResponsable(String nomResponsable) {
		this.nomResponsable = nomResponsable;
	}

	public int getRequestType() {
		return this.requestType;
	}

	public void setRequestType(int requestType) {
		this.requestType = requestType;
	}

}