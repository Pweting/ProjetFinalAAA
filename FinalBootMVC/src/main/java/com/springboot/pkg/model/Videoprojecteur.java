package com.springboot.pkg.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
@DiscriminatorValue("V")
public class Videoprojecteur extends Materiel {
	
	private Module module;
	
	@Version
	private int version;
	

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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	

}
