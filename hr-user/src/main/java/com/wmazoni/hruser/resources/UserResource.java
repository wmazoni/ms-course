package com.wmazoni.hruser.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wmazoni.hruser.entities.User;
import com.wmazoni.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	private static Logger logger = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private Environment env;

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		logger.info("PORT = " + env.getProperty("local.server.port"));
		User obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}	

	@GetMapping(value = "/search")
	public ResponseEntity<User> findById(@RequestParam String email) {
		logger.info("PORT = " + env.getProperty("local.server.port"));
		User obj = repository.findByEmail(email);
		return ResponseEntity.ok(obj);
	}
}
