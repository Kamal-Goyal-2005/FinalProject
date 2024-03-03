package com.caltech.medicineorderspringrest.pogo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "xxordermedicine")
public class Medicine {
	   @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
	    private String medicine_name;
	    private Integer quantity;
	    private Integer price;
	    private String name;
	    private String phone;
	    private String address;
	    
	    @ManyToOne
		private Payment paymentId;

	    
	    @ManyToOne
		private Shipment shipmentId;
}
