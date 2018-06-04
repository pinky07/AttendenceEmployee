package com.posh.attendenceEmployee.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="payroll")
public class Payroll {

	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @Column(name = "employee_id")
	 private int employeeid;

	
	 @Column(name = "date_of_join")
	 @DateTimeFormat(pattern = "yyyy-mm-dd")
	 @Temporal(TemporalType.DATE)
	 private Date  dateOfJoin;
	 
	 
	 @Digits(integer=5, fraction=2)
	 @Column(name = "salary")
	 private BigDecimal salary;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getEmployeeid() {
		return employeeid;
	}


	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}


	public Date getDateOfJoin() {
		return dateOfJoin;
	}


	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}


	public BigDecimal getSalary() {
		return salary;
	}


	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Payroll [id=" + id + ", employeeid=" + employeeid + ", dateOfJoin=" + dateOfJoin + ", salary=" + salary
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfJoin == null) ? 0 : dateOfJoin.hashCode());
		result = prime * result + employeeid;
		result = prime * result + id;
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
		Payroll other = (Payroll) obj;
		if (dateOfJoin == null) {
			if (other.dateOfJoin != null)
				return false;
		} else if (!dateOfJoin.equals(other.dateOfJoin))
			return false;
		if (employeeid != other.employeeid)
			return false;
		if (id != other.id)
			return false;
		
		return true;
	} 
}
