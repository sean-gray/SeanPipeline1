package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.UserService;
import com.revature.model.User;

@RestController
@RequestMapping(value="/user")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	private static UserService userService;
	@Autowired
	public void setUserService(UserService userService) {
		UserController.userService = userService;
	}
	
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getAllUsers(){
		return UserController.userService.findAll();
	}
}
