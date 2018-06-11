package com.springboot.pkg.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "F")
public class Formateur extends RH {

	@OneToMany(mappedBy = "key.formateur")
	private List<Competence> matiere;

	@OneToMany(mappedBy = "formateur")
	private List<Module> module;
	
	private Competence competence;

	public Formateur() {

	}

	public List<Competence> getMatiere() {
		return matiere;
	}

	public void setMatiere(List<Competence> matiere) {
		this.matiere = matiere;
	}

	public List<Module> getModule() {
		return module;
	}

	public void setModule(List<Module> module) {
		this.module = module;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((matiere == null) ? 0 : matiere.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formateur other = (Formateur) obj;
		if (matiere == null) {
			if (other.matiere != null)
				return false;
		} else if (!matiere.equals(other.matiere))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		return true;
	}

}
