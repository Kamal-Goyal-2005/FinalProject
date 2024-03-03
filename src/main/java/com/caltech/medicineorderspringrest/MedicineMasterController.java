package com.caltech.medicineorderspringrest;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caltech.medicineorderspringrest.pogo.Medicine;
import com.caltech.medicineorderspringrest.pogo.MedicineMaster;
import com.caltech.medicineorderspringrest.service.MedicineMasterService;
import com.caltech.medicineorderspringrest.service.MedicineService;

@RestController
@CrossOrigin(origins = "*")
public class MedicineMasterController {

Logger log=Logger.getAnonymousLogger();
	
	@Autowired
	MedicineMasterService service;
	
	@GetMapping("/getMasterMedicines")
	public List<MedicineMaster> getAllMedicinies(HttpServletRequest request,HttpServletResponse response){
		return service.getAllMasterMedicinies();
	}
	
	@DeleteMapping("/deleteMedicineMaster/{id}")
	public String deleteMedicineById(@PathVariable Integer id) {
		return service.deleteMedicineMasterById(id);
	}
	
	@PostMapping("/updateMedicineMaster")
	public String update(@RequestBody MedicineMaster medicine,
			HttpServletRequest request,HttpServletResponse response) {
		return service.updateMedicineMaster(medicine);
	}
	
	
	@PostMapping("/addMedicineMaster")
	public String insert(@RequestBody MedicineMaster medicine,
			HttpServletRequest request,HttpServletResponse response) {
		return service.addMedicineMaster(medicine);
	}
	
	
	@GetMapping("/getMasterMedicine/{id}")
	public MedicineMaster getMedicineById(@PathVariable Integer id) {
		return service.getMasterMedicineById(id);
	}
	
}
