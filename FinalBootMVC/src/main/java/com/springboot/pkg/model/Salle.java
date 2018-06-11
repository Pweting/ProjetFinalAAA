package com.springboot.pkg.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("S")
public class Salle extends Materiel {
	
	private Integer nbPersonnes;
	
	@OneToMany (mappedBy = "salle")
	private List<Module> modules;
	
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

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	
	
	

}
