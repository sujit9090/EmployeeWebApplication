package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 	@Column
	    private String firstName;
		@Column
	    private String lastName;
	    @Column
	    private String salary;
	    @Column
	    private String department;
	    @Column
	    private String email;
	    @Column
	    private String password;
	    @Column
	    private String address;
	    @Column
	    private String mobileNumber;
	    public int getId() 
		{
			return id;
		}
		public void setId(int id)
		{
			this.id = id;
		}
		public String getFirstName()
		{
			return firstName;
		}
		public void setFirstName(String firstName) 
		{
			this.firstName = firstName;
		}
		public String getLastName() 
		{
			return lastName;
		}
		public void setLastName(String lastName)
		{
			this.lastName = lastName;
		}
		public String getSalary()
		{
			return salary;
		}
		public void setSalary(String salary)
		{
			this.salary = salary;
		}
		public String getDepartment() 
		{
			return department;
		}
		public void setDepartment(String department)
		{
			this.department = department;
		}
		public String getEmail()
		{
			return email;
		}
		public void setEmail(String email)
		{
			this.email = email;
		}
		public String getPassword()
		{
			return password;
		}
		public void setPassword(String password)
		{
			this.password = password;
		}
		public String getAddress() 
		{
			return address;
		}
		public void setAddress(String address)
		{
			this.address = address;
		}
		public String getMobileNumber() 
		{
			return mobileNumber;
		}
		public void setMobileNumber(String mobileNumber) 
		{
			this.mobileNumber = mobileNumber;
		}
}

