package com.springboot.pkg.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.pkg.model.jsonview.JsonViews;


@Entity
public class Formation {

	@Id
	@SequenceGenerator(name = "formationSeq", sequenceName = "formation_seq", allocationSize = 1)
	@GeneratedValue(generator = "formationSeq", strategy = GenerationType.SEQUENCE)
	@JsonView(JsonViews.Common.class)
	private Long id;
	@JsonView(JsonViews.Common.class)
	private Date date_debut;
	@JsonView(JsonViews.Common.class)
	private Date date_fin;


	@OneToMany (mappedBy = "formation")	
	private Set<Module> modules;

	@OneToMany(mappedBy="formation")
	private Set<Stagiaire> stagiaires;

	public Formation() {

	}

	public Long getId() { 
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}


	public Set<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(Set<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Formation other = (Formation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	 

}
