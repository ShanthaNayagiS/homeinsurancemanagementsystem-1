package com.insurance.controller;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.exception.UserNotFoundException;
import com.insurance.model.UserEntry;
import com.insurance.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String welcome() {
		return "Welcome to User Controller";
	}

	@PostMapping(value = "/createuser")
	public UserEntry createUser(@Validated @RequestBody UserEntry user) throws UserNotFoundException {
		LOGGER.info("UserEntry Added!!!");

		return userService.createUser(user);
	}

	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public List<UserEntry> getAllUser() throws UserNotFoundException {
		return userService.getAllUser();
	}

	@RequestMapping(value = "/getuser/userid/{userId}", method = RequestMethod.GET)
	public UserEntry getDetailsByUserId(@PathVariable("userId") int Id) throws UserNotFoundException {
		Optional<UserEntry> user = userService.getDetailsByUserId(Id);
		return user.get();
	}

	@RequestMapping(value = "/getuser/username/{userId}", method = RequestMethod.GET)
	public UserEntry getDetailsByUserName(@PathVariable("userName") String uName) throws UserNotFoundException {
		Optional<UserEntry> user = userService.getDetailsByUserName(uName);
		return user.get();
	}

	@PutMapping(value = "/updateuser")
	public UserEntry updateUserDetails(@RequestBody UserEntry user) throws UserNotFoundException {
		LOGGER.info("UserEntry updated!!!");

		return userService.updateUser(user);
	}

	@RequestMapping(value = "/deleteuser/{userId}", method = RequestMethod.DELETE)
	public String deleteUserDetails(@PathVariable("userId") int Id) throws UserNotFoundException {
		Optional<UserEntry> p = userService.getDetailsByUserId(Id);
		if (p.isPresent()) {
			userService.deleteUserDetailsById(Id);
			return "The Policy Details deleted with the userId : " + Id;
		}
		return "The Policy Details Not deleted with the userId : " + Id;
	}
}