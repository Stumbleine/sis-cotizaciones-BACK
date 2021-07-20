package com.umss.dev.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.umss.dev.entity.Privilege;
import com.umss.dev.entity.Role;
import com.umss.dev.entity.UserRole;
import com.umss.dev.entity.UserSis;
import com.umss.dev.repository.PrivilegeRepository;
import com.umss.dev.repository.RoleRepository;

@Component
public class CreateUserAdmin implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private PrivilegeRepository privilegeReposiroty;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public void run(String... args) throws Exception {
		
		if(privilegeReposiroty.findAll().size()==0) {
			
			UserSis newUser=new UserSis();
			newUser.setName("Admin");
			newUser.setUserName("Admin");
			newUser.setEmail("admin@gmail.com");
			newUser.setPassword(encoder.encode("tis2021"));
			newUser.setRegistrationDate(LocalDate.now());
			UserSis saveUser=userService.save(newUser);
			
			Role role=new Role();
			role.setRoleName("ADMIN");
			role.setDescription("El admin se encarga de registrar usuarios, unidades de gasto, administracion, crear nuevos roles");
			Role newRole=roleRepository.save(role);
			
			Privilege privilegeAdmin=new Privilege();
			privilegeAdmin.setPrivilege("ROLE_ADMIN");
			privilegeAdmin.setIdentifier(1);
			Privilege privilegeAdmin2=privilegeReposiroty.save(privilegeAdmin);
			privilegeAdmin2.setRoles(newRole);
			privilegeReposiroty.save(privilegeAdmin2);
			Privilege privilege2=new Privilege();
			privilege2.setPrivilege("ROLE_CREAR_PEDIDO");
			privilege2.setIdentifier(2);
			Privilege privilege3=new Privilege();
			privilege3.setPrivilege("ROLE_VER_PEDIDO");
			privilege3.setIdentifier(2);
			Privilege privilege4=new Privilege();
			privilege4.setPrivilege("ROLE_VER_INFORME");
			privilege4.setIdentifier(2);
			Privilege privilege5=new Privilege();
			privilege5.setPrivilege("ROLE_VER_DETALLE_PEDIDO");
			privilege5.setIdentifier(3);
			Privilege privilege6=new Privilege();
			privilege6.setPrivilege("ROLE_GESTIONAR_COTIZACIONES");
			privilege6.setIdentifier(3);
			Privilege privilege7=new Privilege();
			privilege7.setPrivilege("ROLE_TOMAR_DECISION");
			privilege7.setIdentifier(3);
			
			privilegeReposiroty.save(privilege2);
			privilegeReposiroty.save(privilege3);
			privilegeReposiroty.save(privilege4);
			privilegeReposiroty.save(privilege5);
			privilegeReposiroty.save(privilege6);
			privilegeReposiroty.save(privilege7);
			
			UserRole userRole=new UserRole();
			UserRole userRole2=userRoleService.save(userRole);	
			userRole2.setRole(newRole);
			userRole2.setUser(saveUser);
			userRoleService.save(userRole);		
		}
		
	}

}
