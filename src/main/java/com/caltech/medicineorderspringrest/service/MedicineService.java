package com.caltech.medicineorderspringrest.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caltech.medicineorderspringrest.pogo.Medicine;
import com.caltech.medicineorderspringrest.pogo.Payment;
import com.caltech.medicineorderspringrest.pogo.Shipment;
import com.caltech.medicineorderspringrest.repo.MedicineRepository;
import com.caltech.medicineorderspringrest.repo.PaymentRepository;
import com.caltech.medicineorderspringrest.repo.ShipmentRepository;

@Service
public class MedicineService {
	
	Logger log=Logger.getAnonymousLogger();
	
	@Autowired
	MedicineRepository service;
	

	
	  private final PaymentRepository paymentservice;
	  private final ShipmentRepository shipmentService;

	  @Autowired
	  public MedicineService(PaymentRepository paymentservice,ShipmentRepository shipmentService) {
	      this.paymentservice = paymentservice;
	      this.shipmentService = shipmentService;
	  }
		
	public String insert(Medicine medicine) {
		Medicine m=service.save(medicine);
		if (m==null) {
			return "Error in adding the Medicine";
		} else {
			return "Medicine added successfully";
		}
		
	}
	
	public List<Medicine> getAllMedicinies(){
		return service.findAll();
	}
	
	public Medicine getMedicineById(Integer id) {
		return service.findById(id).orElse(null);
	}
	
	public List<Medicine> getMedicinesByName(String name){
		return service.getMedicinesByName(name);
	}
	
	public String deleteMedicineById(Integer id) {
		service.deleteById(id);
		return "Medicine deleted successfully";
	}
	

	public String updateMedicine(Medicine medicine) {
		
		Medicine m1 = service.findById(medicine.getId()).get();
		if (m1 != null) {
		    m1.setAddress(medicine.getAddress());
		    m1.setPhone(medicine.getPhone());
		//    m1.setName(medicine.getName());
		}
		
		m1.setQuantity(medicine.getQuantity());
		m1.setPrice(medicine.getPrice());
		
		Medicine m=service.save(m1);
		if (m==null) {
			return "Error in updating the Medicine";
		} else {
			return "Medicine updated successfully";
		}
	}
	
	public List<Medicine> getMedicinesForPayment(String name){
			
		return service.getMedicinesForPayment(name);
	}
	
	
	public String updatePayment(String name) {
		 List<Medicine> medicines = service.getMedicinesForPayment(name);
		 List<Payment> payments =paymentservice.getAllPayment();
		 Payment p = new Payment();
		 if (!payments.isEmpty()) {
				p = payments.get(0);
			}
	 
		 for (Medicine m:medicines) {
			 m.setPaymentId(p);
			 Medicine m1=service.save(m);
		 }
	 
		 
		 return "Payment "+p.getPaymentId()+" Updated for Medicines";
		 
	}
	
	public List<Medicine> getMedicinesForShipment(String name){
		
		
		return service.getMedicinesForShipment(name);
	}

	public String updateShipment(String name) {
		 List<Medicine> medicines = service.getMedicinesForShipment(name);
		 List<Shipment> shipments =shipmentService.getAllShipment();
		 Shipment p = new Shipment();
		 if (!shipments.isEmpty()) {
				p = shipments.get(0);
			}
	 
		 for (Medicine m:medicines) {
			 m.setShipmentId(p);
			 Medicine m1=service.save(m);
		 }
	 
		 
		 return "Shipment "+p.getShipmentId()+" Updated for Medicines";
		 
	}

}
