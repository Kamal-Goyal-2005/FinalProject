package com.caltech.medicineorderspringrest;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caltech.medicineorderspringrest.pogo.Medicine;
import com.caltech.medicineorderspringrest.service.MedicineService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

@RestController
@CrossOrigin(origins = "*")
public class MedicineController {
	
	Logger log=Logger.getAnonymousLogger();
	
	@Autowired
	MedicineService service;
	
	@PostMapping("/addMedicine")
	public String insert(@RequestBody Medicine medicine,
			HttpServletRequest request,HttpServletResponse response) {
		return service.insert(medicine);
	}
	
	@GetMapping("/getMedicines")
	public List<Medicine> getAllMedicinies(HttpServletRequest request,HttpServletResponse response){
		return service.getAllMedicinies();
	}
	
	@GetMapping("/getMedicine/{id}")
	public Medicine getMedicineById(@PathVariable Integer id) {
		return service.getMedicineById(id);
	}
	
	@GetMapping("/getMedicineByName/{name}")
	public List<Medicine> getMedicineByName(@PathVariable String name) {
		return service.getMedicinesByName(name);
	}
	
	@DeleteMapping("/deleteMedicine/{id}")
	public String deleteMedicineById(@PathVariable Integer id) {
		return service.deleteMedicineById(id);
	}
	
	@PostMapping("/updateMedicine")
	public String update(@RequestBody Medicine medicine,
			HttpServletRequest request,HttpServletResponse response) {
		return service.updateMedicine(medicine);
	}	
	
	
	@PostMapping("/updatePayment/{name}")
	public String updatePayment(@PathVariable String name,
			HttpServletRequest request,HttpServletResponse response) {
		return service.updatePayment(name);
	}
	
	@PostMapping("/updateShipment/{name}")
	public String updateShipment(@PathVariable String name,
			HttpServletRequest request,HttpServletResponse response) {
		return service.updateShipment(name);
	}
	
}
