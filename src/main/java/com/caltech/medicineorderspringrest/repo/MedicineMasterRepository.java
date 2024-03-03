package com.caltech.medicineorderspringrest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caltech.medicineorderspringrest.pogo.MedicineMaster;

public interface MedicineMasterRepository extends JpaRepository<MedicineMaster,Integer>{

}
