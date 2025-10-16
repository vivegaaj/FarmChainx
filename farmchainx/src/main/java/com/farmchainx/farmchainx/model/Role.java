 package com.farmchainx.farmchainx.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.Set;

import jakarta.persistence.Column;


@Entity
 @Table(name="role")

public class Role 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   
   private long id;
   
   @Column(name="name",nullable = false,unique=true)
   
   private String roleName;
   
   @ManyToMany(mappedBy="roles")
   
   private Set<User> users;
   
   public long getId() 
   {
	return id;
   }

   public Set<User> getUsers() 
   {
	return users;
}

   public void setUsers(Set<User> users) 
   {
	this.users = users;
   }

   public void setId(long id) 
   {
	this.id = id;
   }

   public String getRoleName() 
   {
	return roleName;
   }

   public void setRoleName(String roleName) 
   {
	this.roleName = roleName;
   }
   
   
}