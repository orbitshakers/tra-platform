package org.orbitshakers.tra.controller;


import java.util.List;

import org.orbitshakers.tra.domain.Domain;
import org.orbitshakers.tra.domain.Questionnaire;
import org.orbitshakers.tra.service.TraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TraController {

	
    private final TraService traService;

    private final static Logger logger = LoggerFactory.getLogger(TraController.class);

    @Autowired
    public TraController(TraService traService) {

	this.traService = traService;
    }

    @GetMapping("/domains")
    public ResponseEntity<List<Domain>> getAllDomains() {
	logger.info("Get all available domains");

		return ResponseEntity.ok(traService.findAllDomains());
    }
    
    @GetMapping("/questionnaire")
    public ResponseEntity<Questionnaire> getQuestionnaire() {
	logger.info("Get questionnaire");

		return ResponseEntity.ok(traService.getQuestionnaire());
    }

}
