package com.springboot.pkg.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Videoprojecteur extends Materiel {

}
