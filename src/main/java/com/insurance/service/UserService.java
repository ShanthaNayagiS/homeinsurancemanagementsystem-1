package com.insurance.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.exception.UserNotFoundException;
import com.insurance.model.UserEntry;
import com.insurance.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public UserEntry createUser(UserEntry user)throws UserNotFoundException{
		return userRepository.save(user);
	}

	public List<UserEntry> getAllUser()throws UserNotFoundException {
		return (List<UserEntry>) userRepository.findAll();
	}

	public Optional<UserEntry> getDetailsByUserId(int id)throws UserNotFoundException {
		return userRepository.findById(id);
		
	}

	public UserEntry updateUser(UserEntry user)throws UserNotFoundException {
		return userRepository.save(user);
	}

	public void deleteUserDetailsById(int id) throws UserNotFoundException{
		userRepository.deleteById(id);
		
	}
	public Optional<UserEntry> getDetailsByUserName(String uName)throws UserNotFoundException {
		return userRepository.findByUserName(uName);
	}

}
