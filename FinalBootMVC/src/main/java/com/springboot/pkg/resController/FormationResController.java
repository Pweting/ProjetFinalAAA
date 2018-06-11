package com.springboot.pkg.resController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pkg.repository.FormationRepository;

@RestController
@RequestMapping("/rest/formation")
 
public class FormationResController {
	
	@Autowired
	private FormationRepository formationRepository;

}
