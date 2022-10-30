package com.ms.users.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.users.service.UsersService;
import com.ms.users.shared.UserDto;
import com.ms.users.ui.model.UserRequestModel;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private Environment env;
	
	@Autowired
	UsersService usersService;
	
	@GetMapping("/status")
	public String status() {
		return "working on port "+ env.getProperty("local.server.port");
	}
	
	@PostMapping
	public ResponseEntity createUser(@Valid @RequestBody UserRequestModel userRequestModel) {
		
		ModelMapper modelmapper = new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserDto userDto = modelmapper.map(userRequestModel, UserDto.class);
		usersService.createUser(userDto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
}
