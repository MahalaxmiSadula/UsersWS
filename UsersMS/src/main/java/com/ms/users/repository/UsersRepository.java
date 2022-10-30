package com.ms.users.repository;

import org.springframework.data.repository.CrudRepository;

import com.ms.users.data.UserEntity;


public interface UsersRepository extends CrudRepository<UserEntity, Long> {

}
