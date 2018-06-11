package com.springboot.pkg.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.pkg.model.jsonview.JsonViews;

@Entity
public class Module {
	
	@Id
	@SequenceGenerator(name = "ModuleSeq", sequenceName = "Module_Seq", allocationSize = 1)
	@GeneratedValue(generator = "ModuleSeq", strategy = GenerationType.SEQUENCE)
	@JsonView(JsonViews.Common.class)
	private Long Id;

	@ManyToOne
	@JoinColumn(name = "formateur")
	@JsonView(JsonViews.Common.class)
	private Formateur formateur;
	
	@ManyToOne
	@JoinColumn(name = "matiere")
	@JsonView(JsonViews.Common.class)
	private Matiere matiere;
	
	@JsonView(JsonViews.Common.class)
	private Date dateDebut;
	@JsonView(JsonViews.Common.class)
	private Date dateFin;
	
	@ManyToOne 
	@JoinColumn (name="salle_id")
	@JsonView(JsonViews.Common.class)
	private Salle salle;

	@Version
	private int version;
	
	@OneToOne(mappedBy="module")
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

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
	
}