package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
public class UserContronller implements CommandLineRunner {
	private List<User> users = new ArrayList<User>();
    @Override
    public void run(String... args)  {
        users.add(new User(1, "user 1"));
        users.add(new User(2, "user 2"));
    }

	@GetMapping("/users")
	public List<User> getAll(){
		return users;
	}
}
