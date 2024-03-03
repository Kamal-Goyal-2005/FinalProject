package com.caltech.medicineorderspringrest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caltech.medicineorderspringrest.pogo.Medicine;


public interface MedicineRepository extends JpaRepository<Medicine,Integer>{

	String sql="select m from Medicine m where name=?1";
	
	@Query(sql)
	public List<Medicine> getMedicinesByName(String name);

	String sql2="select m from Medicine m where name=?1 and paymentId is null";
	
	@Query(sql2)
	public List<Medicine> getMedicinesForPayment(String name);
	
     String sql3="select m from Medicine m where name=?1 and shipmentId is null";
	
	@Query(sql3)
	public List<Medicine> getMedicinesForShipment(String name);
 

}
