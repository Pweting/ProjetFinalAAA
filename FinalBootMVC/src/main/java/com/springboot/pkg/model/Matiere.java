package com.springboot.pkg.model;

public class Matiere {
	
	private Long id;
	private String titre;
	private Integer duree;
	private String prerequis;
	private String contenu;
	private String objectif;
	
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
	
	
	

}
