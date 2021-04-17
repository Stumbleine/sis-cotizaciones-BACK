package com.umss.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umss.dev.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
