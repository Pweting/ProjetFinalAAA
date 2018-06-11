package com.springboot.pkg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.pkg.model.Formation;
import com.springboot.pkg.model.Module;
import com.springboot.pkg.model.Stagiaire;

public interface FormationRepository extends JpaRepository<Formation, Long> {
	
//	@Query ("select distinct f from Formation f left outer join fetch f.stagiaires")
//	public List<Formation> findAllStagiairesInFormation();
//	
//	@Query ("select distinct f from Formation f left outer join fetch f.modules")
//	public List<Formation> findAllModulesInFormation();

}
