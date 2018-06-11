package com.springboot.pkg.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

public class Module {
	
	private Long Id;
	private Salle salle;
	private Formateur formateur;
	private Matiere matiere;
	private Date dateDebut;
	private Date dateFin;
	private int version;
	private Videoprojecteur videoProjecteur;
	private Formation formation;
	
	
	public Module() {
		
	}

	@Id
	@SequenceGenerator(name = "ModuleSeq", sequenceName = "Module_Seq", allocationSize = 1)
	@GeneratedValue(generator="ModuleSeq", strategy=GenerationType.SEQUENCE)
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	@OneToMany(mappedBy="salle")
	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	@ManyToOne
	@JoinColumn(name = "Formateur")
	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@ManyToOne
	@JoinColumn(name = "Matiere")
	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
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

	@OneToOne
	public Videoprojecteur getVideoProjecteur() {
		return videoProjecteur;
	}

	public void setVideoProjecteur(Videoprojecteur videoProjecteur) {
		this.videoProjecteur = videoProjecteur;
	}

	@OneToMany(mappedBy="formation")
	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	

}
