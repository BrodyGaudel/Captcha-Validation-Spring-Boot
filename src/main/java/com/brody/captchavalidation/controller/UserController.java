package com.brody.captchavalidation.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brody.captchavalidation.service.UserService;
import com.brody.captchavalidation.utility.CaptchaUtil;
import com.brody.captchavalidation.entity.User;


import cn.apiclub.captcha.Captcha;

/**
 * 
 * @author brody
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	private void getCaptcha(User user) {
		Captcha captcha = CaptchaUtil.createCaptcha(240, 70);
		user.setHiddenCaptcha(captcha.getAnswer());
		user.setCaptcha(""); // value entered by the User
		user.setRealCaptcha(CaptchaUtil.encodeCaptcha(captcha));	
	}
	
	@GetMapping("/register")
	public String registerUser(Model model) {
		User user = new User();
		getCaptcha(user);
		model.addAttribute("user", user);
		return "registerUser";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user, Model model) {
		
		if(user.getCaptcha().equals(user.getHiddenCaptcha())) {
			userService.createUser(user);
			model.addAttribute("message", "User Registered successfully!");
			return "redirect:allUsers";
		} 
		else {
			model.addAttribute("message", "Invalid Captcha");
			getCaptcha(user);
			model.addAttribute("user", user);
		}
		return "registerUser";
	}
	
	@GetMapping("/allUsers")
	public String getAllUsers(Model model) {
		List<User> userList= userService.getAllUsers();
		model.addAttribute("userList", userList);
		return "listUsers";
	}
	
	
	
		
}
