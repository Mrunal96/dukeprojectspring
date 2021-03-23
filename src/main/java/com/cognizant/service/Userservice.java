package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.User;
import com.cognizant.repository.Userrepo;


@Service
public class Userservice {
@Autowired
Userrepo userrepo;
public void saveUser(User user) {
	userrepo.save(user);
}

public Iterable<User> showAllUsers(){
	return userrepo.findAll();
}

public Iterable<User> deleteByProjectname(String projectname){
	userrepo.deleteByProjectname(projectname);
	return userrepo.findAll();
	
}
public User findByProjectname(String projectname) {
	return userrepo.findByProjectname(projectname);
}

public User update(User user) {
	String email = user.getEmail();
	User usr =userrepo.findById(email).get();
	usr.setEmail(user.getEmail());
	usr.setProjectname(user.getProjectname());
	usr.setManagername(user.getManagername());
	usr.setId(user.getId());
	usr.setLocation(user.getLocation());
	return userrepo.save(usr);
}
public Userservice() {
	
}
public Userservice(Userrepo userrepo) {
	super();
	this.userrepo = userrepo;
}

}
