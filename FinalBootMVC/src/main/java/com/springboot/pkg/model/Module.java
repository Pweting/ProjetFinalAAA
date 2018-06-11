package com.springboot.pkg.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
public class Module {
	@Id
	@SequenceGenerator(name = "ModuleSeq", sequenceName = "Module_Seq", allocationSize = 1)
	@GeneratedValue(generator = "ModuleSeq", strategy = GenerationType.SEQUENCE)
	private Long Id;

	@ManyToOne
	@JoinColumn(name = "formateur")
	private Formateur formateur;
	@ManyToOne
	@JoinColumn(name = "matiere")
	private Matiere matiere;
	private Date dateDebut;
	private Date dateFin;
	@ManyToOne 
	@JoinColumn (name="salle_id")
	private Salle salle;

	@Version
	private int version;
	@OneToOne
	private Videoprojecteur videoProjecteur;

	@ManyToOne
	@JoinColumn(name = "formation")
	private Formation formation;

	public Module() {

	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Videoprojecteur getVideoProjecteur() {
		return videoProjecteur;
	}

	public void setVideoProjecteur(Videoprojecteur videoProjecteur) {
		this.videoProjecteur = videoProjecteur;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
