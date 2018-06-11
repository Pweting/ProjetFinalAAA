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

import com.springboot.pkg.model.Module;
import com.springboot.pkg.repository.ModuleRepository;


@RestController
@RequestMapping("/rest/module")
@CrossOrigin(origins = "*")

public class ModuleResController {
	
	@Autowired
	private ModuleRepository moduleRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Module> findById(@PathVariable(name = "id") Long id) {
		Optional<Module> opt = moduleRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Module>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Module>(HttpStatus.NO_CONTENT);
		}

	}

	@RequestMapping(path = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Module>> findAll() {
		return new ResponseEntity<List<Module>>(moduleRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
		Optional<Module> opt = moduleRepository.findById(id);
		if (opt.isPresent()) {
			moduleRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = { "/module", "/module/" }, method = RequestMethod.POST)
	// post = creation
	public ResponseEntity<Void> createModule(@RequestBody Module module, BindingResult br,
			UriComponentsBuilder ucb) {

		ResponseEntity<Void> response = null;

		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (module.getId() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			moduleRepository.save(module);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/personne/{id}").buildAndExpand(module.getId()).toUri());

			response = new ResponseEntity<>(header, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = { "/module", "/module/" }, method = RequestMethod.PUT)
	public ResponseEntity<Module> updateModule(@RequestBody Module module, BindingResult br) {
		ResponseEntity<Module> response = null;
		if (module.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Module> opt = moduleRepository.findById(module.getId());
		if (opt.isPresent()) {
			Module moduleEnBase = opt.get();
			moduleEnBase.setDateDebut(module.getDateDebut());
			moduleEnBase.setDateFin( module.getDateFin());
			moduleEnBase.setFormateur(module.getFormateur());
			moduleEnBase.setMatiere(module.getMatiere());
			moduleEnBase.setSalle(module.getSalle());

			moduleRepository.save(moduleEnBase);
			response = new ResponseEntity<Module>(moduleEnBase, HttpStatus.OK);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

}

