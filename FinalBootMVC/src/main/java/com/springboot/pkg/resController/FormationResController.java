package com.springboot.pkg.resController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pkg.model.Formation;
import com.springboot.pkg.repository.FormationRepository;

@RestController
@RequestMapping("/rest/formation")
@CrossOrigin(origins = "*")

public class FormationResController {

	@Autowired
	private FormationRepository formationRepository;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	// path variable, le nom de ce qu'on veut récuperer
	public ResponseEntity<Formation> findById(@PathVariable(name = "id") Long id) {
		Optional<Formation> opt = formationRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Formation>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Formation>(HttpStatus.NO_CONTENT);
		}

	}

	@RequestMapping(path = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Formation>> findAll() {
		return new ResponseEntity<List<Formation>>(formationRepository.findAll(), HttpStatus.OK);
	}
	
//	//trouver les stagiaires d'une formation et les modules d'une formation 
//	 
//	@RequestMapping(value = "/stagiaires", method = RequestMethod.GET)
//	public ResponseEntity<List<Formation>> findWithStagiaires() {
//		return new ResponseEntity<List<Formation>>(formationRepository.findAllStagiairesInFormation(), HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/modules", method = RequestMethod.GET)
//	public ResponseEntity<List<Formation>> findWithModules() {
//		return new ResponseEntity<List<Formation>>(formationRepository.findAllModulesInFormation(), HttpStatus.OK);
//	}

}
