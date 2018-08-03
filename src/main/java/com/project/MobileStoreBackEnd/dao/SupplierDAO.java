package com.project.MobileStoreBackEnd.dao;

import java.util.List;

import com.project.MobileStoreBackEnd.model.Supplier;


public interface SupplierDAO {
	
	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);	
	public Supplier getSupplier(int supplierID);
	public List<Supplier> listSuppliers();

}
