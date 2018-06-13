package com.springboot.pkg.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.pkg.model.jsonview.JsonViews;

@Entity
@DiscriminatorValue(value = "S")
public class Stagiaire extends RH {

	
	@OneToOne(mappedBy="stagiaire")
	private Ordinateur ordinateur;
	
	@ManyToOne
	@JoinColumn(name = "formation")
	@JsonView(JsonViews.Common.class)
	private Formation formation;
	
	public Stagiaire() {

	}


	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	
	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	
}
