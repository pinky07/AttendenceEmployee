package com.posh.attendenceEmployee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="attendence")
public class Attendence {

	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "attendence_id", nullable = false)
	 private Employee employee;
	 

	 @Temporal(TemporalType.TIMESTAMP)
	 @CreationTimestamp
	 @Column(name = "start_time")
	 private Date  startTime;
	 

	 public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	@Temporal(TemporalType.TIMESTAMP) 
	 @UpdateTimestamp
	 @Column(name = "end_time")
	 private Date  endTime;


	@Override
	public String toString() {
		return "Attendence [id=" + id + ", employee=" + employee + ", startTime=" + startTime + ", endTime=" + endTime
				+ "]";
	}
}
