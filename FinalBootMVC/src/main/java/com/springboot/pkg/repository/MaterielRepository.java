package com.springboot.pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.pkg.model.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel, Long> {
	

}
