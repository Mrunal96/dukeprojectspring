package com.cognizant.repository;

import org.springframework.data.repository.CrudRepository;


import com.cognizant.model.User;


public interface Userrepo extends CrudRepository<User, String>{
   public Iterable<User> deleteByProjectname(String projectname);
   public User findByProjectname(String projectname);
}
