package com.springboot.pkg.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("V")
public class Videoprojecteur extends Materiel {
	
	@OneToOne
	private Module module;
	

	public Videoprojecteur() {
		super();
	}
	

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	

}
