package com.umss.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umss.dev.entity.UserSis;

@Repository
public interface UserRepository extends JpaRepository<UserSis, Integer> {
	UserSis findByUserName(String name);
}
