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
import com.springboot.pkg.model.Formateur;
import com.springboot.pkg.model.Gestionnaire;
import com.springboot.pkg.model.RH;
import com.springboot.pkg.model.Stagiaire;
import com.springboot.pkg.model.Technicien;
import com.springboot.pkg.model.jsonview.JsonViews;
import com.springboot.pkg.repository.RHRepository;

@RestController
@RequestMapping("/rest/rh")
@CrossOrigin(origins = "*")

public class RHresController {

	@Autowired
	private RHRepository rhRepository;

	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RH> findById(@PathVariable(name = "id") Long id) {
		Optional<RH> opt = rhRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<RH>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<RH>(HttpStatus.NO_CONTENT);
		}

	}

	@JsonView(JsonViews.Common.class)
	@RequestMapping(path = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<RH>> findAll() {
		return new ResponseEntity<List<RH>>(rhRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
		Optional<RH> opt = rhRepository.findById(id);
		if (opt.isPresent()) {
			rhRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = { "/gestionnaire", "/gestionnaire/" }, method = RequestMethod.POST)
	// post = creation
	public ResponseEntity<Void> createGestionnaire(@RequestBody Gestionnaire gestionnaire, BindingResult br, UriComponentsBuilder ucb) {

		ResponseEntity<Void> response = null;

		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (gestionnaire.getId() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			rhRepository.save(gestionnaire);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/rh/{id}").buildAndExpand(gestionnaire.getId()).toUri());

			response = new ResponseEntity<>(header, HttpStatus.OK);
		}
		return response;
	}
	
	@RequestMapping(path = { "/formateur", "/formateur/" }, method = RequestMethod.POST)
	public ResponseEntity<Void> createFormateur(@RequestBody Formateur formateur, BindingResult br, UriComponentsBuilder ucb) {

		ResponseEntity<Void> response = null;

		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (formateur.getId() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			rhRepository.save(formateur);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/rh/{id}").buildAndExpand(formateur.getId()).toUri());

			response = new ResponseEntity<>(header, HttpStatus.OK);
		}
		return response;
	}
	
	@RequestMapping(path = { "/stagiaire", "/stagiaire/" }, method = RequestMethod.POST)
	public ResponseEntity<Void> createStagiaire(@RequestBody Stagiaire stagiaire, BindingResult br, UriComponentsBuilder ucb) {

		ResponseEntity<Void> response = null;

		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (stagiaire.getId() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			rhRepository.save(stagiaire);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/rh/{id}").buildAndExpand(stagiaire.getId()).toUri());

			response = new ResponseEntity<>(header, HttpStatus.OK);
		}
		return response;
	}
	
	@RequestMapping(path = { "/technicien", "/technicien/" }, method = RequestMethod.POST)
	public ResponseEntity<Void> createTechnicien(@RequestBody Technicien technicien, BindingResult br, UriComponentsBuilder ucb) {

		ResponseEntity<Void> response = null;

		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (technicien.getId() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			rhRepository.save(technicien);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/rh/{id}").buildAndExpand(technicien.getId()).toUri());

			response = new ResponseEntity<>(header, HttpStatus.OK);
		}
		return response;
	}
	
	
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(path = { "/formateur", "/formateur/" }, method = RequestMethod.PUT)
	public ResponseEntity<RH> updateFormateur(@RequestBody Formateur formateur, BindingResult br) {
		ResponseEntity<RH> response = null;
		if (formateur.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<RH> opt = rhRepository.findById(formateur.getId());
		if (opt.isPresent()) {
			RH rhEnBase = opt.get();
			rhEnBase.setEmail(formateur.getEmail());
			rhEnBase.setLogin(formateur.getLogin());
			rhEnBase.setMdp(formateur.getMdp());
			rhEnBase.setNom(formateur.getNom());
			rhEnBase.setPrenom(formateur.getPrenom());
			rhEnBase.setTelephone(formateur.getTelephone());
			rhRepository.save(rhEnBase);
			response = new ResponseEntity<RH>(rhEnBase, HttpStatus.OK);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	@JsonView(JsonViews.Common.class)
	@RequestMapping(path = { "/stagiaire", "/stagiaire/" }, method = RequestMethod.PUT)
	public ResponseEntity<RH> updateStagiaire(@RequestBody Stagiaire stagiaire, BindingResult br) {
		ResponseEntity<RH> response = null;
		if (stagiaire.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<RH> opt = rhRepository.findById(stagiaire.getId());
		if (opt.isPresent()) {
			RH rhEnBase = opt.get();
			rhEnBase.setEmail(stagiaire.getEmail());
			rhEnBase.setLogin(stagiaire.getLogin());
			rhEnBase.setMdp(stagiaire.getMdp());
			rhEnBase.setNom(stagiaire.getNom());
			rhEnBase.setPrenom(stagiaire.getPrenom());
			rhEnBase.setTelephone(stagiaire.getTelephone());
			rhRepository.save(rhEnBase);
			response = new ResponseEntity<RH>(rhEnBase, HttpStatus.OK);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(path = { "/technicien", "/technicien/" }, method = RequestMethod.PUT)
	public ResponseEntity<RH> updateTechnicien(@RequestBody Technicien technicien, BindingResult br) {
		ResponseEntity<RH> response = null;
		if (technicien.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<RH> opt = rhRepository.findById(technicien.getId());
		if (opt.isPresent()) {
			RH rhEnBase = opt.get();
			rhEnBase.setEmail(technicien.getEmail());
			rhEnBase.setLogin(technicien.getLogin());
			rhEnBase.setMdp(technicien.getMdp());
			rhEnBase.setNom(technicien.getNom());
			rhEnBase.setPrenom(technicien.getPrenom());
			rhEnBase.setTelephone(technicien.getTelephone());
			rhRepository.save(rhEnBase);
			response = new ResponseEntity<RH>(rhEnBase, HttpStatus.OK);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(path = { "/gestionnaire", "/gestionnaire/" }, method = RequestMethod.PUT)
	public ResponseEntity<RH> updateGestionnaire(@RequestBody Gestionnaire gestionnaire, BindingResult br) {
		ResponseEntity<RH> response = null;
		if (gestionnaire.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<RH> opt = rhRepository.findById(gestionnaire.getId());
		if (opt.isPresent()) {
			RH rhEnBase = opt.get();
			rhEnBase.setEmail(gestionnaire.getEmail());
			rhEnBase.setLogin(gestionnaire.getLogin());
			rhEnBase.setMdp(gestionnaire.getMdp());
			rhEnBase.setNom(gestionnaire.getNom());
			rhEnBase.setPrenom(gestionnaire.getPrenom());
			rhEnBase.setTelephone(gestionnaire.getTelephone());
			rhRepository.save(rhEnBase);
			response = new ResponseEntity<RH>(rhEnBase, HttpStatus.OK);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}
}
