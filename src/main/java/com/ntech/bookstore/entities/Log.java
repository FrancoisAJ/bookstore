package com.ntech.bookstore.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Logs")
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "log_date", nullable = false)
	private Date log_date;

	@Column(name = "action", nullable = false)
	private String action;

	@Column(name = "details")
	private String details;

	@ManyToOne
	@JoinColumn(name = "logs_id")
	private Utilisateur utilisateur;

	public Log() {
	}

	public Log(Date log_date, String action) {
		this.log_date = log_date;
		this.action = action;
	}

	public Log(Date log_date, String action, String details) {
		this.log_date = log_date;
		this.action = action;
		this.details = details;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getLog_date() {
		return log_date;
	}

	public void setLog_date(Date log_date) {
		this.log_date = log_date;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
