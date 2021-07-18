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
			String privilege = p.getPrivilege().substring(5);
			found.setIdentifier(p.getIdentifier());
			found.setPrivilege(privilege);
			String newNameP="";
			for (int i=0;i<found.getPrivilege().length();i++) {
				char c=found.getPrivilege().toLowerCase().charAt(i);
						if(c=='_') {
							c=' ';
						}
				newNameP=newNameP+c;
			}
			int size=allPrivilegeOutput.size();
			int j =0;
			
			for(int i=0; i<size;i++) {
				if(newNameP.equalsIgnoreCase(allPrivilegeOutput.get(i).getPrivilege())) {
					j=1;
				}
			}
            if(!p.getPrivilege().equals("ROLE_ADMIN")) {
            	if(allPrivilegeOutput.size()==0 || j==0) {
        			found.setPrivilege(newNameP);
    				allPrivilegeOutput.add(found);
    			}
            }
			
		}
		return allPrivilegeOutput;
	}
	
}
