package com.caltech.medicineorderspringrest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.caltech.medicineorderspringrest.pogo.Login;
import com.caltech.medicineorderspringrest.repo.LoginRepository;




@Service
public class LoginService {

	@Autowired
	LoginRepository loginservice;
	
	Logger log=Logger.getAnonymousLogger();
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public String register(Login login) {
		
		loginservice.save(login);
		return "User registered successfully";
	}
	
	public boolean validateuser(String name, String pwd) {
		
		String encodedpwd =  loginservice.validateuser(name);
		log.info("encodedpwd:"+encodedpwd);
		log.info("pwd:"+pwd);
		log.info("Test:"+passwordEncoder.matches(pwd, encodedpwd));
		return (encodedpwd != null && passwordEncoder.matches(pwd, encodedpwd));
	}
	
	public boolean checkAdmin(String name, String pwd) {

		
        String encodedpwd =  loginservice.checkAdmin(name);
		return (encodedpwd != null && passwordEncoder.matches(pwd, encodedpwd));
	}
	
	public List<Login> findAllUsers(){
		return loginservice.findAll();
	}
	
	public Login findByName(String name) {
		return loginservice.findByName(name);
	}
	
}
