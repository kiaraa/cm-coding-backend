package com.cmcoding.users;

import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<UserEntity, Long> {
	// query methods
}
