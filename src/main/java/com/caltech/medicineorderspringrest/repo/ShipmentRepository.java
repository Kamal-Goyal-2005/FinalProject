package com.caltech.medicineorderspringrest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.caltech.medicineorderspringrest.pogo.Payment;
import com.caltech.medicineorderspringrest.pogo.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment,Integer>{
	String sql = "select p from Shipment p where p.shipmentId not in "
			+ " (select m.shipmentId from Medicine m)";
		
	  @Query(sql)
	   public List<Shipment> getAllShipment();
}
