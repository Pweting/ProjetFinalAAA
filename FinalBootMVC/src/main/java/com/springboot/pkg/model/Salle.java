package com.springboot.pkg.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.pkg.model.jsonview.JsonViews;

@Entity
@DiscriminatorValue("S")
public class Salle extends Materiel {
	@JsonView(JsonViews.Common.class)
	private Integer nbPersonnes;
	
	@OneToMany (mappedBy = "salle")
	private Set<Module> modules;
	
	public Salle() {

	}

	public Salle(Integer nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}

	public Integer getNbPersonnes() {
		return nbPersonnes;
	}

	public void setNbPersonnes(Integer nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}
	
	
	
	

}
