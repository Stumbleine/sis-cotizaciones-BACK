package com.umss.dev.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.Privilege;
import com.umss.dev.entity.UserSis;
import com.umss.dev.output.PrivilegeOutput;
import com.umss.dev.output.UserOutput;
import com.umss.dev.repository.PrivilegeRepository;

@Service
public class PrivilegeService {

	@Autowired
	private PrivilegeRepository privilegeRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	public Iterable<PrivilegeOutput> getAllPrivileges(){
		List <Privilege> allPrivileges = privilegeRepository.findAll();
		List <PrivilegeOutput> allPrivilegeOutput = new ArrayList<PrivilegeOutput>();

		for(Privilege p:allPrivileges) {
		
			PrivilegeOutput found=new PrivilegeOutput();
			found.setIdentifier(p.getIdentifier());
			found.setPrivilege(p.getPrivilege());
			int size=allPrivilegeOutput.size();
			int j =0;
			
			for(int i=0; i<size;i++) {
				if(p.getPrivilege().equalsIgnoreCase(allPrivilegeOutput.get(i).getPrivilege())) {
					j=1;
				}
			}
            if(!p.getPrivilege().equals("ROLE_ADMIN")) {
            	if(allPrivilegeOutput.size()==0 || j==0) {
    				allPrivilegeOutput.add(found);
    			}
            }
			
			
		}
		return allPrivilegeOutput;
	}
	
}
