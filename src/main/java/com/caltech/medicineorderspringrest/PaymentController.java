package com.caltech.medicineorderspringrest;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caltech.medicineorderspringrest.pogo.Medicine;
import com.caltech.medicineorderspringrest.pogo.Payment;
import com.caltech.medicineorderspringrest.service.PaymentService;
@RestController
@CrossOrigin(origins = "*")
public class PaymentController {

Logger log=Logger.getAnonymousLogger();
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/addPayment")
	public Integer addPayment(@RequestBody Payment payment,
			HttpServletRequest request,HttpServletResponse response) {
		return paymentService.addPayment(payment);
	}
	
	
	@GetMapping("/getPayments")
	public List<Payment> getAllPayments(HttpServletRequest request,HttpServletResponse response){
		return paymentService.getAllPayment();
	}
	
	@GetMapping("/getPayment")
	public Integer getPayment(HttpServletRequest request,HttpServletResponse response){
		return paymentService.getpayment();
	}
}
