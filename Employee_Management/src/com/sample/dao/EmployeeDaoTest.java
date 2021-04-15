package com.sample.dao;
import org.junit.Test;
import junit.framework.TestCase;

import java.util.List;
import com.sample.model.DepartmentTO;
import com.sample.model.EmployeeTO;
import com.sample.dao.EmployeeDao;

import java.util.Date;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class EmployeeDaoTest extends TestCase {
	

	@Test //public void addEmp(EmployeeTO)
	public void testAddEmp(){
		EmployeeDao e0Obj = new EmployeeDao();
		EmployeeTO e0Arg0 = new EmployeeTO();
		e0Arg0.setFirstName("Suresh");
		e0Arg0.setEmail("Suresh.Kumar@gmail.com");
		Date e0Arg03Arg0 = new Date("11/17/1982");
		

		e0Arg0.setDob(e0Arg03Arg0);
		e0Arg0.setLastName("Kumar");
		DepartmentTO e0Arg05Arg0 = new DepartmentTO();
		e0Arg05Arg0.setDepartId(1);
		e0Arg05Arg0.setDepartName("Accounting");
		

		e0Arg0.setDepartment(e0Arg05Arg0);
		

		try{
			e0Obj.addEmp(e0Arg0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void deleteEmp(int)
	public void testDeleteEmp(){
		EmployeeDao e0Obj = new EmployeeDao();
		try{
			e0Obj.deleteEmp(72);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void updateEmp(EmployeeTO)
	public void testUpdateEmp(){
		EmployeeDao e0Obj = new EmployeeDao();
		EmployeeTO e0Arg0 = new EmployeeTO();
		e0Arg0.setUserid(17);
		e0Arg0.setFirstName("Danny D");
		e0Arg0.setEmail("DannyD@gmail.com");
		Date e0Arg03Arg0 = new Date("04/17/1983");
		e0Arg0.setDob(e0Arg03Arg0);
		e0Arg0.setLastName("Deol");
		DepartmentTO e0Arg05Arg0 = new DepartmentTO();
		e0Arg05Arg0.setDepartId(1);
		e0Arg0.setDepartment(e0Arg05Arg0);

		try{
			e0Obj.updateEmp(e0Arg0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public List<EmployeeTO> getAllEmp()
	public void testGetAllEmp(){
		EmployeeDao e0Obj = new EmployeeDao();
		try{
			List<EmployeeTO> e0 = e0Obj.getAllEmp();
			//TODO Based on your need, provide necessary assertion condition
		assertNotNull(e0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public EmployeeTO getEmpById(int)
	public void testGetEmpById(){
		EmployeeDao e0Obj = new EmployeeDao();
		try{
			EmployeeTO e0 = e0Obj.getEmpById(23);
			//TODO Based on your need, provide necessary assertion condition
		assertEquals("Sharukh", e0.getFirstName());
		}catch(Exception e){
			fail();
		}
	}
	

	@Test
	public void testSequence(){
		EmployeeDao e0Obj = new EmployeeDao();
		EmployeeTO e0Arg0 = new EmployeeTO();
		e0Arg0.setUserid(14);
		e0Arg0.setFirstName("Ashwin");
		e0Arg0.setEmail("ashwin.seshadri@gmail.com");
		Date e0Arg03Arg0 = new Date();
		

		e0Arg0.setDob(e0Arg03Arg0);
		e0Arg0.setLastName("Seshadri");
		DepartmentTO e0Arg05Arg0 = new DepartmentTO();
		e0Arg05Arg0.setDepartId(2);

		e0Arg0.setDepartment(e0Arg05Arg0);
		

		try{
			e0Obj.addEmp(e0Arg0);
		}catch(Exception e){
			fail();
		}
		try{
			e0Obj.deleteEmp(20);
		}catch(Exception e){
			fail();
		}
		EmployeeTO e2Arg0 = new EmployeeTO();
		e0Arg0.setUserid(38);
		e2Arg0.setFirstName("Mridula");
		e2Arg0.setEmail("mridula.seshadri@gmail.com");
		Date e2Arg03Arg0 = new Date();
		

		e2Arg0.setDob(e2Arg03Arg0);
		e2Arg0.setLastName("Seshadri");
		DepartmentTO e2Arg05Arg0 = new DepartmentTO();
		e2Arg05Arg0.setDepartId(3);
		

		e2Arg0.setDepartment(e2Arg05Arg0);
		

		try{
			e0Obj.updateEmp(e2Arg0);
		}catch(Exception e){
			fail();
		}
		try{
			List<EmployeeTO> e3 = e0Obj.getAllEmp();
			//TODO Based on your need, provide necessary assertion condition
		assertNotNull(e3);
		}catch(Exception e){
			fail();
		}
		try{
			EmployeeTO e4 = e0Obj.getEmpById(10);
			//TODO Based on your need, provide necessary assertion condition
		assertEquals("Sunitha", e4.getFirstName());
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void addEmp(EmployeeTO)
	public void testAddEmpMin(){
		EmployeeDao e0Obj = new EmployeeDao();
		EmployeeTO e0Arg0 = new EmployeeTO();
		e0Arg0.setUserid(-2147483648);
		e0Arg0.setFirstName(null);
		e0Arg0.setEmail(null);
		Date e0Arg03Arg0 = new Date();
		

		e0Arg0.setDob(e0Arg03Arg0);
		e0Arg0.setLastName(null);
		DepartmentTO e0Arg05Arg0 = new DepartmentTO();
		e0Arg05Arg0.setDepartId(3);
		e0Arg05Arg0.setDepartName(null);
		

		e0Arg0.setDepartment(e0Arg05Arg0);
		

		try{
			e0Obj.addEmp(e0Arg0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void addEmp(EmployeeTO)
	public void testAddEmpMax(){
		EmployeeDao e0Obj = new EmployeeDao();
		EmployeeTO e0Arg0 = new EmployeeTO();
		e0Arg0.setUserid(2147483647);
		e0Arg0.setFirstName("abcdefghijabcdefghijabcdefghij");
		e0Arg0.setEmail("abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij");
		Date e0Arg03Arg0 = new Date();
		

		e0Arg0.setDob(e0Arg03Arg0);
		e0Arg0.setLastName("abcdefghijabcdefghijabcdefghij");
		DepartmentTO e0Arg05Arg0 = new DepartmentTO();
		e0Arg05Arg0.setDepartId(4);
		e0Arg05Arg0.setDepartName("abcdefghijabcdefghijabcdefghij");
		

		e0Arg0.setDepartment(e0Arg05Arg0);
		

		try{
			e0Obj.addEmp(e0Arg0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void addEmp(EmployeeTO)
	public void testAddEmpNull(){
		EmployeeDao e0Obj = new EmployeeDao();
		EmployeeTO e0Arg0 = new EmployeeTO();
		e0Arg0.setUserid(17);
		e0Arg0.setFirstName(null);
		e0Arg0.setEmail(null);
		Date e0Arg03Arg0 = new Date();
		

		e0Arg0.setDob(e0Arg03Arg0);
		e0Arg0.setLastName(null);
		DepartmentTO e0Arg05Arg0 = new DepartmentTO();
		e0Arg05Arg0.setDepartId(2);
		e0Arg05Arg0.setDepartName(null);
		

		e0Arg0.setDepartment(e0Arg05Arg0);
		

		try{
			e0Obj.addEmp(e0Arg0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void addEmp(EmployeeTO)
	public void testAddEmpSplChar(){
		EmployeeDao e0Obj = new EmployeeDao();
		EmployeeTO e0Arg0 = new EmployeeTO();
		e0Arg0.setUserid(-25);
		e0Arg0.setFirstName("		~!@#$%^&*()_+,./;'[]<>?:\\{}|\" ");
		e0Arg0.setEmail("		~!@#$%^&*()_+,./;'[]<>?:\\{}|\" ");
		Date e0Arg03Arg0 = new Date();
		

		e0Arg0.setDob(e0Arg03Arg0);
		e0Arg0.setLastName("		~!@#$%^&*()_+,./;'[]<>?:\\{}|\" ");
		DepartmentTO e0Arg05Arg0 = new DepartmentTO();
		e0Arg05Arg0.setDepartId(3);
		e0Arg05Arg0.setDepartName("		~!@#$%^&*()_+,./;'[]<>?:\\{}|\" ");
		

		e0Arg0.setDepartment(e0Arg05Arg0);
		

		try{
			e0Obj.addEmp(e0Arg0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void deleteEmp(int)
	public void testDeleteEmpMin(){
		EmployeeDao e0Obj = new EmployeeDao();
		try{
			e0Obj.deleteEmp(-2147483648);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void deleteEmp(int)
	public void testDeleteEmpMax(){
		EmployeeDao e0Obj = new EmployeeDao();
		try{
			e0Obj.deleteEmp(2147483647);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void deleteEmp(int)
	public void testDeleteEmpNull(){
		EmployeeDao e0Obj = new EmployeeDao();
		try{
			e0Obj.deleteEmp(85);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void deleteEmp(int)
	public void testDeleteEmpSplChar(){
		EmployeeDao e0Obj = new EmployeeDao();
		try{
			e0Obj.deleteEmp(-45);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void updateEmp(EmployeeTO)
	public void testUpdateEmpMin(){
		EmployeeDao e0Obj = new EmployeeDao();
		EmployeeTO e0Arg0 = new EmployeeTO();
		e0Arg0.setUserid(-2147483648);
		e0Arg0.setFirstName(null);
		e0Arg0.setEmail(null);
		Date e0Arg03Arg0 = new Date();
		

		e0Arg0.setDob(e0Arg03Arg0);
		e0Arg0.setLastName(null);
		DepartmentTO e0Arg05Arg0 = new DepartmentTO();
		e0Arg05Arg0.setDepartId(3);
		e0Arg05Arg0.setDepartName(null);
		

		e0Arg0.setDepartment(e0Arg05Arg0);
		

		try{
			e0Obj.updateEmp(e0Arg0);
			
		}catch(Exception e){
			fail();
		
		}
	}
	

	@Test //public void updateEmp(EmployeeTO)
	public void testUpdateEmpMax(){
		EmployeeDao e0Obj = new EmployeeDao();
		EmployeeTO e0Arg0 = new EmployeeTO();
		e0Arg0.setUserid(2147483647);
		e0Arg0.setFirstName("abcdefghijabcdefghijabcdefghij");
		e0Arg0.setEmail("abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij");
		Date e0Arg03Arg0 = new Date(2147483647,2147483647,2147483647);
		

		e0Arg0.setDob(e0Arg03Arg0);
		e0Arg0.setLastName("abcdefghijabcdefghijabcdefghij");
		DepartmentTO e0Arg05Arg0 = new DepartmentTO();
		e0Arg05Arg0.setDepartId(1);
		e0Arg05Arg0.setDepartName("abcdefghijabcdefghijabcdefghij");
		

		e0Arg0.setDepartment(e0Arg05Arg0);
		

		try{
			e0Obj.updateEmp(e0Arg0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void updateEmp(EmployeeTO)
	public void testUpdateEmpNull(){
		EmployeeDao e0Obj = new EmployeeDao();
		EmployeeTO e0Arg0 = new EmployeeTO();
		e0Arg0.setUserid(-42);
		e0Arg0.setFirstName(null);
		e0Arg0.setEmail(null);
		Date e0Arg03Arg0 = new Date();
		

		e0Arg0.setDob(e0Arg03Arg0);
		e0Arg0.setLastName(null);
		DepartmentTO e0Arg05Arg0 = new DepartmentTO();
		e0Arg05Arg0.setDepartId(2);
		e0Arg05Arg0.setDepartName("");
		

		e0Arg0.setDepartment(e0Arg05Arg0);
		

		try{
			e0Obj.updateEmp(e0Arg0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void updateEmp(EmployeeTO)
	public void testUpdateEmpSplChar(){
		EmployeeDao e0Obj = new EmployeeDao();
		EmployeeTO e0Arg0 = new EmployeeTO();
		e0Arg0.setUserid(-24);
		e0Arg0.setFirstName("~!@#$%^&*()_+,./;'[]<>?:\\{}");
		e0Arg0.setEmail("~!@#$%^&*()_+,./;'[]<>?:\\{}");
		Date e0Arg03Arg0 = new Date();
		

		e0Arg0.setDob(e0Arg03Arg0);
		e0Arg0.setLastName("~!@#$%^&*()_+,./;'[]<>?:\\{}");
		DepartmentTO e0Arg05Arg0 = new DepartmentTO();
		e0Arg05Arg0.setDepartId(3);
		e0Arg05Arg0.setDepartName("~!@#$%^&*()_+,");
		

		e0Arg0.setDepartment(e0Arg05Arg0);
		

		try{
			e0Obj.updateEmp(e0Arg0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public EmployeeTO getEmpById(int)
	public void testGetEmpByIdMin(){
		EmployeeDao e0Obj = new EmployeeDao();
		try{
			EmployeeTO e0 = e0Obj.getEmpById(12);
			//TODO Based on your need, provide necessary assertion condition
			assertEquals("Advika", e0.getFirstName());
			assertEquals("Karthikeyan", e0.getLastName());
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public EmployeeTO getEmpById(int)
	public void testGetEmpByIdMax(){
		EmployeeDao e0Obj = new EmployeeDao();
		try{
			EmployeeTO e0 = e0Obj.getEmpById(12);
			//TODO Based on your need, provide necessary assertion condition
		assertEquals("Advika", e0.getFirstName());
		assertEquals("Karthikeyan", e0.getLastName());
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public EmployeeTO getEmpById(int)
	public void testGetEmpByIdNull(){
		EmployeeDao e0Obj = new EmployeeDao();
		try{
			EmployeeTO e0 = e0Obj.getEmpById(100);
			//TODO Based on your need, provide necessary assertion condition
		assertNull(e0.getFirstName());
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public EmployeeTO getEmpById(int)
	public void testGetEmpByIdSplChar(){
		EmployeeDao e0Obj = new EmployeeDao();
		try{
			EmployeeTO e0 = e0Obj.getEmpById(57);
			//TODO Based on your need, provide necessary assertion condition
		assertNotNull(e0);
		}catch(Exception e){
			fail();
		}
	}
	

}
