package com.farmchainx.farmchainx.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   
	@Column(nullable = false)
   private String name;
   @Column(unique = true, nullable = false)
   private String email;
   
   @Column(unique = true, nullable = false)
   private String password;
   
   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(
		   name = "user_roles",
		   joinColumns = @JoinColumn(name= "user_id"),
		   inverseJoinColumns=@JoinColumn(name="role_id")
		   )
   private Set<Role> roles;

   public Set<Role> getRoles() {
	return roles;
}

   public void setRoles(Set<Role> roles) {
	this.roles = roles;
   }

   public long getId() {
	return id;
   }

   public void setId(long id) {
	this.id = id;
   }

   public String getName() {
	return name;
   }

   public void setName(String name) {
	this.name = name;
   }

   public String getEmail() {
	return email;
   }

   public void setEmail(String email) {
	this.email = email;
   }

   public String getPassword() {
	return password;
   }

   public void setPassword(String password) {
	this.password = password;
   }
   
}
