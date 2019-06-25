package org.orbitshakers.tra.controller;


import java.util.List;

import org.orbitshakers.tra.domain.Domain;
import org.orbitshakers.tra.domain.Questionnaire;
import org.orbitshakers.tra.domain.TraSession;
import org.orbitshakers.tra.service.TraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    	logger.info("getQuestionnaire");

		return ResponseEntity.ok(traService.getQuestionnaire());
    }


    @GetMapping("/start")
    public ResponseEntity<TraSession> start() {
    	logger.info("start");
//    	try {
//    		Thread.sleep(3000);
//    	}
//    	catch (InterruptedException e) {
//		  
//    	}
		return ResponseEntity.ok(traService.createTraSession());
    }
    
    @PostMapping("/save-session-data")
    public ResponseEntity<TraSession> saveSessionData(@RequestBody TraSession traSession) {
    	logger.info("saveSessionData");
		return ResponseEntity.ok(traService.saveTraSession(traSession));
    }

    @GetMapping("/session-data")
    public ResponseEntity<TraSession> getSessionData(@RequestParam("id") String sessionId) {
    	logger.info("sessionData");
		return ResponseEntity.ok(traService.getTraSession(sessionId));
    }
        
    
}
