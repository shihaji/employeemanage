package com.sample.bo;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.sample.dao.EmployeeDao;
import com.sample.model.DepartmentTO;
import com.sample.model.EmployeeTO;
import com.sample.model.UserTO;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class LoginBOTest extends TestCase {
	

	@Test //public List<DepartmentTO> getAllDepart()
	public void testvalidateUser(){
		LoginBO e0Obj = new LoginBO();
		UserTO etobj= new UserTO();
		etobj.setUserid("100");
		etobj.setPassword("madhav");
		try{
		 e0Obj.validateUser(etobj);
			//TODO Based on your need, provide necessary assertion condition
		assertNotNull(etobj);
		}catch(Exception e){
			fail();
		}
	}
	
	

}
