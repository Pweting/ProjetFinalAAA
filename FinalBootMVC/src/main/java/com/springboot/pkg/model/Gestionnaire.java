package com.springboot.pkg.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "G")
public class Gestionnaire extends RH{

	
	public Gestionnaire(){
		
	}
}
