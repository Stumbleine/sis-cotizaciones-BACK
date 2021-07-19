package com.umss.dev.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umss.dev.entity.Privilege;
import com.umss.dev.entity.Role;
import com.umss.dev.entity.SpendingUnit;
import com.umss.dev.entity.UserSis;
import com.umss.dev.exception.DtoNotFoundException;
import com.umss.dev.output.RoleOutput;
import com.umss.dev.output.RoleOutputNormalAtributes;
import com.umss.dev.output.SpendingUnitOutput;
import com.umss.dev.output.UserOutputNormalAtributes;
import com.umss.dev.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	private ModelMapper modelMapper;

	public RoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
	    this.roleRepository = roleRepository;
	    this.modelMapper = modelMapper;
	   
	}
	
	public Role getById(Integer roleId) {
		Role roleAct = roleRepository.findById(roleId).orElse(null);
	    if (null == roleAct) {
	    	
	        throw new DtoNotFoundException(RoleOutputNormalAtributes.class.toString(), roleId);
	    }
	  
	    return roleAct;
	}
	@Transactional
	public Role save(Role role) {
	    Role persistedRole = roleRepository.save(role);
	     for(int i=0;i<persistedRole.getPrivileges().size();i++) {
	    	 String nameP=persistedRole.getPrivileges().get(i).getPrivilege();
	    	 String newNameP="ROLE_";
				for (int j=0;j<nameP.length();j++) {
					char c= nameP.toUpperCase().charAt(j);
							if(c==' ') {
								c='_';
							}
					newNameP=newNameP+c;
				}
			 persistedRole.getPrivileges().get(i).setPrivilege(newNameP);
	     }
	    
	     return persistedRole;
	}
	
	public Iterable<RoleOutput>  getAllRoles(){
		List <Role> allRoles = roleRepository.findAll();
		List <RoleOutput> allRolesByOrder = new ArrayList<RoleOutput>();
		
		
		for (Role found : allRoles) {
			List<Privilege> privileges = new ArrayList<Privilege>();
			
			for (int i = 0; i < found.getPrivileges().size(); i++) {
				Privilege name = new Privilege();
				String privilege = found.getPrivileges().get(i).getPrivilege().substring(5);
				String newNameP = "";
				for (int j = 0; j < privilege.length(); j++) {
					char c = privilege.toLowerCase().charAt(j);
					if (c == '_') {
						c = ' ';
					}
					newNameP = newNameP + c;
				}
				name.setIdentifier(found.getPrivileges().get(i).getIdentifier());
				name.setIdPrivilege(found.getPrivileges().get(i).getIdPrivilege());
				name.setPrivilege(newNameP);
				privileges.add(name);
			}
			RoleOutput newRole = new RoleOutput();
			newRole.setIdRole(found.getIdRole());
			newRole.setRoleName(found.getRoleName());
			newRole.setPrivilegios(privileges);
			if(!found.getRoleName().equalsIgnoreCase("ADMIN")) {
				allRolesByOrder.add(newRole);
			}
			

		}

		Collections.reverse(allRolesByOrder);
		
		return allRolesByOrder;	
	}
}
