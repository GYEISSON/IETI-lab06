/**
 * 
 */
package edu.eci.escuelaing.ieti.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.escuelaing.ieti.model.User;
import edu.eci.escuelaing.ieti.payroll.UserNotFoundException;
import edu.eci.escuelaing.ieti.services.UserService;

/**
 * @author yeisson Gualdron
 *
 */
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	

	  @GetMapping("/users")
	  public List<User> allUsers() {
		  System.out.println("ALL");
		  return userService.getAll();
	  }

	  @PostMapping("/users")
	  public User newUser(@RequestBody User newUser) {
	    return userService.create(newUser);
	  }

	  // Single item
	  
	  @GetMapping("/users/{id}")
	  public User oneUser(@PathVariable String id) {
	    try {
	    	System.out.println(id);
	    	return userService.getById(id);
	    }
	    catch(UserNotFoundException ex) {
	    	Logger.getLogger(User.class.getName()).log(Level.SEVERE, "User Not Found!", ex);	    
	    	return null;
	    }
	  }

	  @PutMapping("/users/{id}")
	  public User replaceUser(@RequestBody User newUser, @PathVariable String id) {
	    
	    try {
			  return userService.update(newUser);
		    }
		    catch(UserNotFoundException ex) {
		    	Logger.getLogger(User.class.getName()).log(Level.SEVERE, "User Not Found!", ex);	    
		    	return null;
		    }
	  }

	  @DeleteMapping("/users/{id}")
	  public void deleteUser(@PathVariable String id) {
		  try {
			  userService.remove(id);
		  }
		  catch(UserNotFoundException ex) {
			  Logger.getLogger(User.class.getName()).log(Level.SEVERE, "User Not Found!", ex);	    
		  }
	  }
}
