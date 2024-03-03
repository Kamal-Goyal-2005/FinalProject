package com.caltech.medicineorderspringrest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caltech.medicineorderspringrest.pogo.Medicine;
import com.caltech.medicineorderspringrest.pogo.Payment;
import com.caltech.medicineorderspringrest.repo.MedicineRepository;
import com.caltech.medicineorderspringrest.repo.PaymentRepository;

@Service
public class PaymentService {

Logger log=Logger.getAnonymousLogger();
	
	
	@Autowired
	PaymentRepository paymentService;
	
	public Integer addPayment(Payment payment) {
		Payment m=paymentService.save(payment);
		
		
		return m.getPaymentId();
	
	}
	
	public List<Payment> getAllPayment() {
		return paymentService.findAll();
	}
	
	public Integer getpayment()
	{
		List<Payment> payments = paymentService.getAllPayment();
		Payment p = new Payment();
		
		if (!payments.isEmpty()) {
			p = payments.get(0);
		}
		
		return p.getPaymentId();
		
	}
	
}
