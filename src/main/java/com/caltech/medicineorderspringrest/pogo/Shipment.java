package com.caltech.medicineorderspringrest.pogo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "xxshipment")
public class Shipment {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer shipmentId;
}
