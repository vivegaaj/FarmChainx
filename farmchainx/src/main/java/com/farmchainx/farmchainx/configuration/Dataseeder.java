package com.farmchainx.farmchainx.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.farmchainx.farmchainx.model.Role;
import com.farmchainx.farmchainx.repository.RoleRepository;


@Component
public class Dataseeder implements CommandLineRunner 
{
	private final RoleRepository roleRepository;
	
	public Dataseeder(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	@Override
   public void run(String...args) throws Exception{
	   
		String[] roles= {"ROLE_CONSUMER","ROLE_FARMER","ROLE_DISTRIBUTER","ROLE_ADMIN"};
		for(String roleName:roles)
		{
			if(!roleRepository.existsByRoleName(roleName)) {
			Role role=new Role();
			role.setRoleName(roleName);
			roleRepository.save(role);
		}
   }
}
}