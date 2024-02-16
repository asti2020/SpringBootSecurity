package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
	@GetMapping("/welcome")
	public String welcome() {
		return "This end point is not secure";
	}
	
	@GetMapping("/user/userProfiles")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String userProfile()
	{
		return "Welcome to the User Profile";
	}
	
	@GetMapping("/admin/adminProfile")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminProfile()
	{
		return "Welcome to admin profile";
	}
	
}
