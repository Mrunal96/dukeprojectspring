package com.cognizant.controller;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.User;
import com.cognizant.service.Userservice;

@RestController
public class Homecontroller {
	
	@Autowired
	private Userservice service;
	
	@PostMapping("/save-user")
	@Transactional
	@CrossOrigin
    public String registerUser(@RequestBody User user) {
	service.saveUser(user);
	return "Hello "+user.getProjectname()+" Members,Your data has been saved!!!";
	}
	
	@GetMapping("/all-users")
	@CrossOrigin
	public Iterable<User> showAllUser(User user){
		return service.showAllUsers();
	}
	
	@GetMapping("delete-user/{projectname}")
	@Transactional
	@CrossOrigin
     public Iterable<User> deleteUser(@PathVariable String projectname){
		return service.deleteByProjectname(projectname);
	}
	
	@GetMapping("/find-users/{projectname}")
	@CrossOrigin
	public User findAllUser(@PathVariable String projectname){
		return service.findByProjectname(projectname);
	}
	
	/*
	 * @PutMapping("/update-user")
	 * 
	 * @Transactional
	 * 
	 * @CrossOrigin public String UpdateUser(@RequestBody User user) {
	 * service.saveUser(user); return
	 * "Hello "+user.getProjectname()+" members, your information has been updated";
	 * }
	 */

	@PutMapping("/update")
	public User Update(@RequestBody User user) {
		return service.update(user);
	}
}
