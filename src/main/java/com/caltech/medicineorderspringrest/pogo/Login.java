package com.caltech.medicineorderspringrest.pogo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "xxusers")
public class Login {
	
    @Id
    private String name;
    private String email;
    private String phone;
    private String pwd;

}
