package com.brody.captchavalidation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brody.captchavalidation.entity.User;

/**
 * 
 * @author brody
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
