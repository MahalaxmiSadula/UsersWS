package com.ms.users.service.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.users.data.UserEntity;
import com.ms.users.repository.UsersRepository;
import com.ms.users.service.UsersService;
import com.ms.users.shared.UserDto;

@Service
public class UsersServiceImpl implements UsersService {
	UsersRepository usersRepository;
	
	@Autowired
	public UsersServiceImpl(UsersRepository usersRepository) {
//		super();
		this.usersRepository = usersRepository;
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		userDto.setUserId(UUID.randomUUID().toString());
		
		ModelMapper modelmapper = new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserEntity userEntity = modelmapper.map(userDto, UserEntity.class);
		userEntity.setEncryptedPassword("test");
		userEntity = usersRepository.save(userEntity);
		
		System.out.println("oute: "+ userEntity.getEmail());

		return null;
		

	}

}
