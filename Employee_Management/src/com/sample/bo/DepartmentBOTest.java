package com.sample.bo;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.sample.model.DepartmentTO;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class DepartmentBOTest extends TestCase {
	

	@Test //public List<DepartmentTO> getAllDepart()
	public void testGetAllDepart(){
		DepartmentBO e0Obj = new DepartmentBO();
		DepartmentTO departmentTO = new DepartmentTO();
		try{
			List<DepartmentTO> e0 = e0Obj.getAllDepart();
			//TODO Based on your need, provide necessary assertion condition
		assertNotNull(e0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void addDepart(String)
	public void testAddDepart(){
		DepartmentBO e0Obj = new DepartmentBO();
		try{
			e0Obj.addDepart("Test");
		}catch(Exception e){
			fail();
		}
	}
	

	@Test
	public void testSequence(){
		DepartmentBO e0Obj = new DepartmentBO();
		try{
			List<DepartmentTO> e0 = e0Obj.getAllDepart();
			//TODO Based on your need, provide necessary assertion condition
		assertNotNull(e0);
		}catch(Exception e){
			fail();
		}
		try{
			e0Obj.addDepart("Test1");
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void addDepart(String)
	public void testAddDepartMin(){
		DepartmentBO e0Obj = new DepartmentBO();
		try{
			e0Obj.addDepart("");
		}catch(Exception e){
			fail();
			
		}
	}
	

	@Test //public void addDepart(String)
	public void testAddDepartMax(){
		DepartmentBO e0Obj = new DepartmentBO();
		try{
			e0Obj.addDepart("abcdefghijabcdeabcdefghij");
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void addDepart(String)
	public void testAddDepartSplChar(){
		DepartmentBO e0Obj = new DepartmentBO();
		try{
			e0Obj.addDepart("~!@#$%^&*()_+,.");
		}catch(Exception e){
			fail();
		}
	}
	

}
