package com.springboot.pkg.resController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.pkg.model.Formation;
import com.springboot.pkg.model.jsonview.JsonViews;
import com.springboot.pkg.repository.FormationRepository;

@RestController
@RequestMapping("/rest/formation")
@CrossOrigin(origins = "*") 

public class FormationResController {

	@Autowired
	private FormationRepository formationRepository;
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Formation> findById(@PathVariable(name = "id") Long id) {
		Optional<Formation> opt = formationRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Formation>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Formation>(HttpStatus.NO_CONTENT);
		}

	}
	@JsonView(JsonViews.Common.class)
	@RequestMapping(path = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Formation>> findAll() {
		return new ResponseEntity<List<Formation>>(formationRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
		Optional<Formation> opt = formationRepository.findById(id);
		if (opt.isPresent()) {
			formationRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = { "/formation", "/formation/" }, method = RequestMethod.POST)
	// post = creation
	public ResponseEntity<Void> createFormation(@RequestBody Formation formation, BindingResult br,
			UriComponentsBuilder ucb) {

		ResponseEntity<Void> response = null;

		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (formation.getId() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			formationRepository.save(formation);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/personne/{id}").buildAndExpand(formation.getId()).toUri());

			response = new ResponseEntity<>(header, HttpStatus.OK);
		}
		return response;
	}
	@JsonView(JsonViews.Common.class)
	@RequestMapping(path = { "/formation", "/formation/" }, method = RequestMethod.PUT)
	public ResponseEntity<Formation> updateFormation(@RequestBody Formation formation, BindingResult br) {
		ResponseEntity<Formation> response = null;
		if (formation.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Formation> opt = formationRepository.findById(formation.getId());
		if (opt.isPresent()) {
			Formation formationEnBase = opt.get();
			formationEnBase.setDateDebut(formation.getDateDebut());
			formationEnBase.setDateFin(formation.getDateFin());
			// prevoir de pouvoir creer des formations avec des listes de
			// mosules ou stagiaires existantes.
			// formationEnBase.setModules(modules);
			// formationEnBase.setStagiaires(stagiaires);

			formationRepository.save(formationEnBase);
			response = new ResponseEntity<Formation>(formationEnBase, HttpStatus.OK);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	// pour avoir les formations avec leurs stagiaires
	@JsonView(JsonViews.FormationWithStagiaires.class)
	@RequestMapping(value = "/stagiaires", method = RequestMethod.GET)
	public ResponseEntity<List<Formation>> findWithStagiaires() {
		return new ResponseEntity<List<Formation>>(formationRepository.findAllWithStagiaires(), HttpStatus.OK);
	}

	// pour avoir les formations avec leurs modules
	@JsonView(JsonViews.FormationWithModules.class)
	@RequestMapping(value = "/modules", method = RequestMethod.GET)
	public ResponseEntity<List<Formation>> findWithModules() {
		return new ResponseEntity<List<Formation>>(formationRepository.findAllWithModules(), HttpStatus.OK);
	}

}
