package com.caltech.medicineorderspringrest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.caltech.medicineorderspringrest.pogo.Payment;


public interface PaymentRepository extends JpaRepository<Payment,Integer>{

String sql = "select p from Payment p where p.paymentId not in "
		+ " (select m.paymentId from Medicine m)";
	
  @Query(sql)
   public List<Payment> getAllPayment();
   
}
