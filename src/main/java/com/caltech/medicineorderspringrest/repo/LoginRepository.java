package com.caltech.medicineorderspringrest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caltech.medicineorderspringrest.pogo.Login;



public interface LoginRepository extends JpaRepository<Login,Integer>{
	
	String sql = "select user.pwd from Login user where user.name=?1";
	
	
	String sql2 = "select user.pwd from Login user where user.name=?1 and user.name='admin'";
	
	String sql3 = "select user from Login user where user.name=?1";

	@Query(sql)
	public String validateuser(String name);
	
	@Query(sql2)
	public String checkAdmin(String name);
	
	@Query(sql3)
	public Login findByName(String name);
}
