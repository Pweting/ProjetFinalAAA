package com.springboot.pkg.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "F")
public class Formateur extends RH {
	@OneToMany(mappedBy = "key.formateur")
	private List<Matiere> matiere;

	@OneToMany(mappedBy = "formateur")
	private List<Module> module;

	public Formateur() {

	}

	public List<Matiere> getMatiere() {
		return matiere;
	}

	public void setMatiere(List<Matiere> matiere) {
		this.matiere = matiere;
		
		
	}

	public List<Module> getModule() {
		return module;
	}

	public void setModule(List<Module> module) {
		this.module = module;
	}

}
