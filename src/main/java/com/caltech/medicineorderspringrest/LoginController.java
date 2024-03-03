package com.caltech.medicineorderspringrest;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caltech.medicineorderspringrest.pogo.Login;
import com.caltech.medicineorderspringrest.service.LoginService;



@RestController
@CrossOrigin(origins="*")
public class LoginController {

	@Autowired
	LoginService loginservice;
	

	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
   

	
	Logger log=Logger.getAnonymousLogger();
	
	
	@PostMapping("/Login")
	public String loginUser(@RequestBody Login user, HttpServletRequest request,HttpServletResponse response) {
		log.info("entered into the / LoginController");
		HttpSession session = request.getSession();
		String retstr = new String();
			String username = user.getName();
			String pwd = user.getPwd();
			System.out.println(username + " " + pwd);
			
			boolean i = loginservice.validateuser(username, pwd);
			boolean j = loginservice.checkAdmin(username, pwd);
		
			log.info("ValidateUser:"+i+", Admin user:"+j);

			if (j) {
				session.setAttribute("LoggedIn", "TRUE");
				retstr="Admin user logged in successfully";
			} else if (i) {
				session.setAttribute("LoggedIn", "TRUE");
				session.setAttribute("name", username);
				retstr=username+" logged in successfully";
			} else {
				retstr="Invalid Username or Password";
			}
			
			log.info("Response:"+retstr);
			return retstr;	
	}
	
	
	@PostMapping("/Register")
	public String registerUser(@RequestBody Login user,HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("entered into the / RegisterController");
		HttpSession session = request.getSession();
		
		//PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String phone = user.getPhone();
		String name = user.getName();
		String email = user.getEmail();
	
		user.setPwd(passwordEncoder.encode(user.getPwd()));

		System.out.println(name + " " + user.getPwd());
		
        String message = loginservice.register(user);
        

		return message;

		// return "sum of numbers is " + result;
	}
	
	@GetMapping("/getAllUsers")
	public List<Login> findAllUsers(){
		return loginservice.findAllUsers();
		
	}
	
	@GetMapping("/getUser/{name}")
	public Login findByName(@PathVariable String name,
			HttpServletRequest request,HttpServletResponse response) {
		return loginservice.findByName(name);
	}
	
	
	
}
