package com.brody.captchavalidation.service;


import java.util.List;
import java.util.Optional;

import com.brody.captchavalidation.entity.User;

/**
 * 
 * @author brody
 *
 */
public interface UserService {
	
	void createUser(User user);
	List<User> getAllUsers();
	Optional<User> getOneUser(Integer id);

}
