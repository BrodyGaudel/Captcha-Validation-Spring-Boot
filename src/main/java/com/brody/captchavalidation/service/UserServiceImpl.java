package com.brody.captchavalidation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brody.captchavalidation.entity.User;
import com.brody.captchavalidation.repository.UserRepository;

/**
 * 
 * @author brody
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}

	@Override
	public void createUser(User user) {
		
		userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
	
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getOneUser(Integer id) {
	
		return userRepository.findById(id);
	}

}
