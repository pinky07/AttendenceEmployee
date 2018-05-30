package com.posh.attendenceEmployee.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;





@Entity
@Table(name="employee")

public class Employee {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	@NotEmpty(message = "*Please provide an userName")
	 @Column(name = "user_name")
	 private String userName;
	 
	 @Length(min = 5, message = "*Your password must have at least 5 characters")
	 @NotEmpty(message = "*Please provide your password")
	 @Transient
	 @Column(name = "password")
	 private String password;
	 
	 @NotEmpty(message = "*Please provide an name")
	 @Column(name = "name")
	 private String name;
	 

	
	 @ManyToOne(fetch = FetchType.LAZY)
	// @JoinTable(name = "employee_profile",joinColumns = @JoinColumn(name = "employee_id"),inverseJoinColumns = @JoinColumn(name = "profile_id"))
	 @JoinColumn(name="profile_id")
	 private Profile profile;
	 

	 @Temporal(TemporalType.TIMESTAMP)
	 @CreationTimestamp
	 @Column(name = "created_date")
	 private Date  createdate;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	 private Set<Attendence> attendence = new HashSet<Attendence>();
	 
public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", userName=" + userName + ", password=" + password + ", name=" + name
				+ ", profile=" + profile + ", createdate=" + createdate + ", attendence=" + attendence + "]";
	}


	public Profile getProfile() {
		return profile;
	}


	public void setProfile(Profile profile) {
		this.profile = profile;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}





	public Date getCreatedate() {
		return createdate;
	}


	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}


public Set<Attendence> getAttendence() {
		return attendence;
	}


	public void setAttendence(Set<Attendence> attendence) {
		this.attendence = attendence;
	}




}