package com.me.finalproject.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="warehouse")
public class Warehouse {
	@Column(name="warehouseName",nullable=false)
	private String warehouseName;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="warehouseID",unique=true,nullable=false)
	private int warehouseID;
	@Column(name="address",nullable=false)
	private String address;
	@Column(name="city",nullable=false)
	private String city;
	@Column(name="state",nullable=false)
	private String state;
	@Column(name="warehouseType",nullable=false)
	private String warehouseType;
	@Column(name="contactNumber")
	private String contactNumber;
	
	public Warehouse() {
	}
	public Warehouse(String warehouseName, int warehouseID, String address, String city, String state,
			String warehouseType, String contactNumber) {
		this.warehouseName = warehouseName;
		this.warehouseID = warehouseID;
		this.address = address;
		this.city = city;
		this.state = state;
		this.warehouseType = warehouseType;
		this.contactNumber = contactNumber;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public int getWarehouseID() {
		return warehouseID;
	}
	public void setWarehouseID(int warehouseID) {
		this.warehouseID = warehouseID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getWarehouseType() {
		return warehouseType;
	}
	public void setWarehouseType(String warehouseType) {
		this.warehouseType = warehouseType;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	

}
