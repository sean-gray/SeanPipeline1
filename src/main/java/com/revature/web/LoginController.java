package com.revature.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

@RestController(value = "loginController")
		@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	private static UserService userService;
	@Autowired
	public void setUserService(UserService userService) {
		LoginController.userService = userService;
	}
	private LoginController() {
		super();
	}
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public User login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session) {
		System.out.println(username);
		System.out.println(password);
		User user = userService.authenticate(username, password);
		if (user != null) {
			session.setAttribute("USER", user);
		} else {
			return null;
		}
		return user;
	}
	@GetMapping("/session")
	public User getSession(HttpSession session) {
		if (session != null) {
			// log.info((User) session.getAttribute("USER"));
			return (User) session.getAttribute("USER");
		}
		return null;
	}
	@GetMapping("/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}
}
