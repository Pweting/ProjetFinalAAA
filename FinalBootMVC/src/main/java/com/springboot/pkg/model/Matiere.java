package com.springboot.pkg.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
public class Matiere {
	
	@Id
	@SequenceGenerator(name = "matiereSeq", sequenceName = "matiere_seq", allocationSize = 1)
	@GeneratedValue(generator="matiereSeq", strategy=GenerationType.SEQUENCE)
	private Long id;
	private String titre;
	private Integer duree;
	private String prerequis;
	private String contenu;
	private String objectif;
	
	@OneToMany(mappedBy="matiere")
	private List<Module> module;
	
	@Version
	private int version;
	
	public Matiere() {

	}

	public Matiere(String titre, Integer duree, String prerequis, String contenu, String objectif) {
		this.titre = titre;
		this.duree = duree;
		this.prerequis = prerequis;
		this.contenu = contenu;
		this.objectif = objectif;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public List<Module> getModule() {
		return module;
	}

	public void setModule(List<Module> module) {
		this.module = module;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
	

}
