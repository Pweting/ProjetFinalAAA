package com.springboot.pkg.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
@DiscriminatorValue("V")
public class Videoprojecteur extends Materiel {
	
	private Module module;
	
	

	public Videoprojecteur() {
		super();
	}
	
	@OneToOne
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	

}
