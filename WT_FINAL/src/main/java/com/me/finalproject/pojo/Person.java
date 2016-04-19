package com.me.finalproject.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Person")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {
	@Column(name="personFirstName", nullable=false)
	private String firstName;
	@Column(name="personLastName",nullable=false)
	private String lastName;
	@Column(name="emailID")
	private String emailID;
	@Column(name="companyAddress")
	private String companyAddress;
	@Id
	@GeneratedValue
	@Column(name="personID",unique = true, nullable=false)
	private long personID;
	//default constructor required to configured it as bean
	public Person(){
		
	}
	public Person(String firstName, String lastName, String emailID, String companyAddress, long personID){
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.companyAddress = companyAddress;
		this.personID = personID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public long getPersonID() {
		return personID;
	}
	public void setPersonID(long personID) {
		this.personID = personID;
	}

}
