package com.project.MobileStoreBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supplierID;
	
	private String supplierName;
	private String  supplierInfo;
	private String supplierContactNo;
	
	
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierInfo() {
		return supplierInfo;
	}
	public void setSupplierInfo(String supplierInfo) {
		this.supplierInfo = supplierInfo;
	}
	public String getSupplierContactNo() {
		return supplierContactNo;
	}
	public void setSupplierContactNo(String supplierContactNo) {
		this.supplierContactNo = supplierContactNo;
	}
	
	
}
