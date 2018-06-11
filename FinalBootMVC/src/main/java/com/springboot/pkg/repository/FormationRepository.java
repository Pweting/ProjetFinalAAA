package com.springboot.pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.pkg.model.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {

}
