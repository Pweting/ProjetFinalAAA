package com.springboot.pkg.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class Salle extends Materiel {
	
	private Integer nbPersonnes;
	
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
	

}
