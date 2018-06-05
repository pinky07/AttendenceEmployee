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
	 

	
	 //@ManyToOne(fetch = FetchType.LAZY)
	// @JoinTable(name = "employee_profile",joinColumns = @JoinColumn(name = "employee_id"),inverseJoinColumns = @JoinColumn(name = "profile_id"))
	 //@JoinColumn(name="profile_id")
	 @Column(name = "profile_id")
	 private int profileID;
	 

	 @Temporal(TemporalType.TIMESTAMP)
	 @CreationTimestamp
	 @Column(name = "created_date")
	 private Date  createdate;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	 private Set<Attendence> attendence = new HashSet<Attendence>();
	 


	






	




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attendence == null) ? 0 : attendence.hashCode());
		result = prime * result + ((createdate == null) ? 0 : createdate.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + profileID;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (attendence == null) {
			if (other.attendence != null)
				return false;
		} else if (!attendence.equals(other.attendence))
			return false;
		if (createdate == null) {
			if (other.createdate != null)
				return false;
		} else if (!createdate.equals(other.createdate))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (profileID != other.profileID)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}





	public int getProfileID() {
		return profileID;
	}





	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
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





	@Override
	public String toString() {
		return "Employee [id=" + id + ", userName=" + userName + ", password=" + password + ", name=" + name
				+ ", profile=" + profileID + ", createdate=" + createdate + ", attendence=" + attendence + "]";
	}





}