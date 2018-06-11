package com.springboot.pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.pkg.model.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {

}
