package com.caltech.medicineorderspringrest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caltech.medicineorderspringrest.pogo.Payment;
import com.caltech.medicineorderspringrest.pogo.Shipment;
import com.caltech.medicineorderspringrest.service.PaymentService;
import com.caltech.medicineorderspringrest.service.ShipmentService;

@RestController
@CrossOrigin(origins = "*")
public class ShipmentController {

	@Autowired
	ShipmentService shipmentService;
	
	@PostMapping("/addShipment")
	public Integer addShipment(@RequestBody Shipment shipment,
			HttpServletRequest request,HttpServletResponse response) {
		return shipmentService.addShipment(shipment);
	}
	
	
	@GetMapping("/getShipments")
	public List<Shipment> getAllShipments(HttpServletRequest request,HttpServletResponse response){
		return shipmentService.getAllShipment();
	}
	
	@GetMapping("/getShipment")
	public Integer getShipment(HttpServletRequest request,HttpServletResponse response){
		return shipmentService.getshipment();
	}
}
