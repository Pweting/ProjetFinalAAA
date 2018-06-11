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
import com.springboot.pkg.model.Materiel;
import com.springboot.pkg.model.jsonview.JsonViews;
import com.springboot.pkg.repository.MaterielRepository;

@RestController
@RequestMapping("/rest/materiel")
@CrossOrigin(origins = "*")

public class MaterielResController {

	@Autowired
	private MaterielRepository materielRepository;

	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Materiel> findById(@PathVariable(name = "id") Long id) {
		Optional<Materiel> opt = materielRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Materiel>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Materiel>(HttpStatus.NO_CONTENT);
		}

	}

	@JsonView(JsonViews.Common.class)
	@RequestMapping(path = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Materiel>> findAll() {
		return new ResponseEntity<List<Materiel>>(materielRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
		Optional<Materiel> opt = materielRepository.findById(id);
		if (opt.isPresent()) {
			materielRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = { "/materiel", "/materiel/" }, method = RequestMethod.POST)
	// post = creation
	public ResponseEntity<Void> createMateriel(@RequestBody Materiel materiel, BindingResult br,
			UriComponentsBuilder ucb) {

		ResponseEntity<Void> response = null;

		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (materiel.getCode() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			materielRepository.save(materiel);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/personne/{id}").buildAndExpand(materiel.getCode()).toUri());

			response = new ResponseEntity<>(header, HttpStatus.OK);
		}
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@RequestMapping(path = { "/materiel", "/materiel/" }, method = RequestMethod.PUT)
	public ResponseEntity<Materiel> updateMateriel(@RequestBody Materiel materiel, BindingResult br) {
		ResponseEntity<Materiel> response = null;
		if (materiel.getCode() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Materiel> opt = materielRepository.findById(materiel.getCode());
		if (opt.isPresent()) {
			Materiel materielEnBase = opt.get();
			materielEnBase.setCout(materiel.getCout());

			materielRepository.save(materielEnBase);
			response = new ResponseEntity<Materiel>(materielEnBase, HttpStatus.OK);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

}
