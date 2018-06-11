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

import com.springboot.pkg.model.RH;
import com.springboot.pkg.repository.RHRepository;

@RestController
@RequestMapping("/rest/rh")
@CrossOrigin(origins = "*")

public class RHresController {

	@Autowired
	private RHRepository rhRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RH> findById(@PathVariable(name = "id") Long id) {
		Optional<RH> opt = rhRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<RH>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<RH>(HttpStatus.NO_CONTENT);
		}

	}

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

	@RequestMapping(path = { "/rh", "/rh/" }, method = RequestMethod.POST)
	// post = creation
	public ResponseEntity<Void> createRh(@RequestBody RH rh, BindingResult br, UriComponentsBuilder ucb) {

		ResponseEntity<Void> response = null;

		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (rh.getId() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			rhRepository.save(rh);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/personne/{id}").buildAndExpand(rh.getId()).toUri());

			response = new ResponseEntity<>(header, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = { "/rh", "/rh/" }, method = RequestMethod.PUT)
	public ResponseEntity<RH> updateRh(@RequestBody RH rh, BindingResult br) {
		ResponseEntity<RH> response = null;
		if (rh.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<RH> opt = rhRepository.findById(rh.getId());
		if (opt.isPresent()) {
			RH rhEnBase = opt.get();
			rhEnBase.setEmail(rh.getEmail());
			rhEnBase.setLogin(rh.getLogin());
			rhEnBase.setMdp(rh.getMdp());
			rhEnBase.setNom(rh.getNom());
			rhEnBase.setPrenom(rh.getPrenom());
			rhEnBase.setTelephone(rh.getTelephone());
			rhRepository.save(rhEnBase);
			response = new ResponseEntity<RH>(rhEnBase, HttpStatus.OK);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

}
