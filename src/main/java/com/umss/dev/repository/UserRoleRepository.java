package com.umss.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umss.dev.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {

}
