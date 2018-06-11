package com.springboot.pkg.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("S")
public class Salle extends Materiel {
	
	private Integer nbPersonnes;
	
	@OneToMany(mappedBy="salle")
	private List<Module> module;
	
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
	
	public List<Module> getModule() {
		return module;
	}

	public void setModule(List<Module> module) {
		this.module = module;
	}
	
	
	

}
