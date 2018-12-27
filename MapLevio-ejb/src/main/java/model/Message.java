package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Messages database table.
 * 
 */
@Entity
@Table(name="Messages")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MessageId")
	private int messageId;

	private int cible;

	private Timestamp dateM;
	
	private String etatM;

	private int suivi;

	@Column(name="TypeMessage")
	private int typeMessage;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="MyClient_Id")
	private AspNetUser aspNetUser1;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="MyResource_Id")
	private AspNetUser aspNetUser2;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="Client_Id")
	private AspNetUser aspNetUser3;

	//bi-directional many-to-one association to Resource
	@ManyToOne
	@JoinColumn(name="Resource_ResourceId")
	private Resource resource;

	public Message() {
	}

	public int getMessageId() {
		return this.messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getCible() {
		return this.cible;
	}

	public void setCible(int cible) {
		this.cible = cible;
	}

	public Timestamp getDateM() {
		return this.dateM;
	}

	public void setDateM(Timestamp dateM) {
		this.dateM = dateM;
	}

	public String getEtatM() {
		return this.etatM;
	}

	public void setEtatM(String etatM) {
		this.etatM = etatM;
	}

	public int getSuivi() {
		return this.suivi;
	}

	public void setSuivi(int suivi) {
		this.suivi = suivi;
	}

	public int getTypeMessage() {
		return this.typeMessage;
	}

	public void setTypeMessage(int typeMessage) {
		this.typeMessage = typeMessage;
	}

	public AspNetUser getAspNetUser1() {
		return this.aspNetUser1;
	}

	public void setAspNetUser1(AspNetUser aspNetUser1) {
		this.aspNetUser1 = aspNetUser1;
	}

	public AspNetUser getAspNetUser2() {
		return this.aspNetUser2;
	}

	public void setAspNetUser2(AspNetUser aspNetUser2) {
		this.aspNetUser2 = aspNetUser2;
	}

	public AspNetUser getAspNetUser3() {
		return this.aspNetUser3;
	}

	public void setAspNetUser3(AspNetUser aspNetUser3) {
		this.aspNetUser3 = aspNetUser3;
	}

	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}