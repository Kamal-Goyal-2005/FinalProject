package com.caltech.medicineorderspringrest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caltech.medicineorderspringrest.pogo.Payment;
import com.caltech.medicineorderspringrest.pogo.Shipment;
import com.caltech.medicineorderspringrest.repo.PaymentRepository;
import com.caltech.medicineorderspringrest.repo.ShipmentRepository;

@Service
public class ShipmentService {
	@Autowired
	ShipmentRepository shipmentService;
	
	public Integer addShipment(Shipment shipment) {
		Shipment m=shipmentService.save(shipment);
		
		
		return  m.getShipmentId();
		
	}
	
Logger log=Logger.getAnonymousLogger();
	
	
		
	public List<Shipment> getAllShipment() {
		return shipmentService.findAll();
	}
	
	public Integer getshipment()
	{
		List<Shipment> shipments = shipmentService.getAllShipment();
		Shipment p = new Shipment();
		
		if (!shipments.isEmpty()) {
			p = shipments.get(0);
		}
		
		return p.getShipmentId();
		
	}
}
