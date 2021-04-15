package com.sample.dao;
import org.junit.Test;
import junit.framework.TestCase;
import com.sample.model.DepartmentTO;
import java.util.List;
import com.sample.dao.DepartmentDao;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class DepartmentDaoTest extends TestCase {
	

	@Test //public void addDepart(String)
	public void testAddDepart(){
		DepartmentDao e0Obj = new DepartmentDao();
		try{
			e0Obj.addDepart("TestFromDAO");
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public List<DepartmentTO> getAllDepart()
	public void testGetAllDepart(){
		DepartmentDao e0Obj = new DepartmentDao();
		try{
			List<DepartmentTO> e0 = e0Obj.getAllDepart();
			//TODO Based on your need, provide necessary assertion condition
			assertNotNull(e0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test
	public void testSequence(){
		DepartmentDao e0Obj = new DepartmentDao();
		try{
			e0Obj.addDepart("Test3");
		}catch(Exception e){
			fail();
		}
		try{
			List<DepartmentTO> e1 = e0Obj.getAllDepart();
			//TODO Based on your need, provide necessary assertion condition
			assertNotNull(e1);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void addDepart(String)
	public void testAddDepartMin(){
		DepartmentDao e0Obj = new DepartmentDao();
		try{
			e0Obj.addDepart("");
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void addDepart(String)
	public void testAddDepartMax(){
		DepartmentDao e0Obj = new DepartmentDao();
		try{
			e0Obj.addDepart("abcdefghijabcdeabcdefghij");
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void addDepart(String)
	public void testAddDepartSplChar(){
		DepartmentDao e0Obj = new DepartmentDao();
		try{
			e0Obj.addDepart("~!@#$%^&*()_+,./;'[]<>?:");
		}catch(Exception e){
			fail();
		}
	}
	

}
