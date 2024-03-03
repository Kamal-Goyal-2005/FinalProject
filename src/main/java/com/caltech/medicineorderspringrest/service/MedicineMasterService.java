package com.caltech.medicineorderspringrest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caltech.medicineorderspringrest.pogo.Medicine;
import com.caltech.medicineorderspringrest.pogo.MedicineMaster;
import com.caltech.medicineorderspringrest.repo.MedicineMasterRepository;
import com.caltech.medicineorderspringrest.repo.MedicineRepository;

@Service
public class MedicineMasterService {

Logger log=Logger.getAnonymousLogger();
	
	@Autowired
	MedicineMasterRepository service;
	
	public List<MedicineMaster> getAllMasterMedicinies(){
		return service.findAll();
	}
	
	public String deleteMedicineMasterById(Integer id) {
		service.deleteById(id);
		return "Medicine Product deleted successfully";
	}
	
	
	public String updateMedicineMaster(MedicineMaster medicine) {
		
		MedicineMaster m=service.save(medicine);
		if (m==null) {
			return "Error in updating the Medicine";
		} else {
			return "Medicine updated successfully";
		}
	}
	
	
	public String addMedicineMaster(MedicineMaster medicine) {
		MedicineMaster m=service.save(medicine);
		if (m==null) {
			return "Error in adding the Medicine";
		} else {
			return "Medicine added successfully";
		}
		
	}
	
	
	public MedicineMaster getMasterMedicineById(Integer id) {
		return service.findById(id).orElse(null);
	}
	
}
