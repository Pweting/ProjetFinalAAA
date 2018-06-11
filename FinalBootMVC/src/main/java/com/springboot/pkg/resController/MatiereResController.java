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

import com.springboot.pkg.model.Matiere;
import com.springboot.pkg.repository.MatiereRepository;

@RestController
@RequestMapping("/rest/matiere")
@CrossOrigin(origins = "*")

public class MatiereResController {

	@Autowired
	private MatiereRepository matiereRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Matiere> findById(@PathVariable(name = "id") Long id) {
		Optional<Matiere> opt = matiereRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Matiere>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Matiere>(HttpStatus.NO_CONTENT);
		}

	}

	@RequestMapping(path = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Matiere>> findAll() {
		return new ResponseEntity<List<Matiere>>(matiereRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
		Optional<Matiere> opt = matiereRepository.findById(id);
		if (opt.isPresent()) {
			matiereRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = { "/matiere", "/matiere/" }, method = RequestMethod.POST)
	// post = creation
	public ResponseEntity<Void> createMatiere(@RequestBody Matiere matiere, BindingResult br,
			UriComponentsBuilder ucb) {

		ResponseEntity<Void> response = null;

		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (matiere.getId() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			matiereRepository.save(matiere);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/personne/{id}").buildAndExpand(matiere.getId()).toUri());

			response = new ResponseEntity<>(header, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = { "/matiere", "/matiere/" }, method = RequestMethod.PUT)
	public ResponseEntity<Matiere> updateMatiere(@RequestBody Matiere matiere, BindingResult br) {
		ResponseEntity<Matiere> response = null;
		if (matiere.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Matiere> opt = matiereRepository.findById(matiere.getId());
		if (opt.isPresent()) {
			Matiere matiereEnBase = opt.get();
			matiereEnBase.setContenu(matiere.getContenu());
			matiereEnBase.setDuree(matiere.getDuree());
			matiereEnBase.setObjectif(matiere.getObjectif());
			matiereEnBase.setPrerequis(matiere.getPrerequis());
			matiereEnBase.setTitre(matiere.getTitre());

			matiereRepository.save(matiereEnBase);
			response = new ResponseEntity<Matiere>(matiereEnBase, HttpStatus.OK);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

}
