package com.sample.bo;
import org.junit.Test;
import junit.framework.TestCase;
import java.util.Date;
import com.sample.model.EmployeeTO;
import com.sample.bo.EmployeeBO;
import com.sample.dao.EmployeeDao;

import java.util.List;
import com.sample.model.DepartmentTO;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class EmployeeBOTest extends TestCase {
	

	@Test //public void addEmp(EmployeeTO)
	public void testAddEmp(){
		EmployeeBO e0Obj = new EmployeeBO();
		EmployeeTO e0Arg0 = new EmployeeTO();
		e0Arg0.setEmail("upa.seshadri@gmail.com");
		Date e0Arg02Arg0 = new Date("04/04/2000");
		

		e0Arg0.setDob(e0Arg02Arg0);
		e0Arg0.setLastName("Seshadri");
		e0Arg0.setFirstName("Upasana");
		DepartmentTO e0Arg05Arg0 = new DepartmentTO();
		e0Arg05Arg0.setDepartId(3);

		e0Arg0.setDepartment(e0Arg05Arg0);
		

		try{
			e0Obj.addEmp(e0Arg0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void deleteEmp(int)
	public void testDeleteEmp(){
		EmployeeBO e0Obj = new EmployeeBO();
		try{
			e0Obj.deleteEmp(47);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public List<EmployeeTO> getAllEmp()
	public void testGetAllEmp(){
		EmployeeBO e0Obj = new EmployeeBO();
		try{
			List<EmployeeTO> e0 = e0Obj.getAllEmp();
			//TODO Based on your need, provide necessary assertion condition
		assertNotNull(e0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void updateEmp(EmployeeTO)
	public void testUpdateEmp(){
		EmployeeBO e0Obj = new EmployeeBO();
		EmployeeTO e0Arg0 = new EmployeeTO();
		e0Arg0.setUserid(48);
		e0Arg0.setEmail("Ravi.Teja@yaho0.com");
		Date e0Arg02Arg0 = new Date("04/17/1982");
		

		e0Arg0.setDob(e0Arg02Arg0);
		e0Arg0.setLastName("Ravi");
		e0Arg0.setFirstName("Teja");
		DepartmentTO e0Arg05Arg0 = new DepartmentTO();
		e0Arg05Arg0.setDepartId(2);

		e0Arg0.setDepartment(e0Arg05Arg0);
		

		try{
			e0Obj.updateEmp(e0Arg0);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public static long daysBetween(Calendar,Calendar)
	public void testDaysBetween(){
		Date e0Arg0 =new Date("04/04/2000");
		Date e0Arg1 = new Date();

		boolean e0 = EmployeeBO.daysBetween(e0Arg0,e0Arg1);
		//TODO Based on your need, provide necessary assertion condition
		assertTrue(e0);
	}
	

	@Test //public EmployeeTO getEmpById(int)
	public void testGetEmpById(){
		EmployeeBO e0Obj = new EmployeeBO();
		try{
			EmployeeTO e0 = e0Obj.getEmpById(53);
			//TODO Based on your need, provide necessary assertion condition
		assertEquals("Suresh", e0.getFirstName());
		}catch(Exception e){
			fail();
		}
	}
	

	@Test
	public void testSequence(){
		EmployeeBO e0Obj = new EmployeeBO();
		EmployeeTO e0Arg0 = new EmployeeTO();
		e0Arg0.setEmail("Saranya.R@gmail.com");
		Date e0Arg02Arg0 = new Date("04/04/1983");
		

		e0Arg0.setDob(e0Arg02Arg0);
		e0Arg0.setLastName("Rajagopalan");
		e0Arg0.setFirstName("Saranya");
		DepartmentTO e0Arg05Arg0 = new DepartmentTO();
		e0Arg05Arg0.setDepartId(4);
		e0Arg0.setDepartment(e0Arg05Arg0);
		

		try{
			e0Obj.addEmp(e0Arg0);
		}catch(Exception e){
			fail();
		}
		try{
			e0Obj.deleteEmp(50);
		}catch(Exception e){
			fail();
		}
		try{
			List<EmployeeTO> e2 = e0Obj.getAllEmp();
			//TODO Based on your need, provide necessary assertion condition
		assertNotNull(e2);
		}catch(Exception e){
			fail();
		}
		EmployeeTO e3Arg0 = new EmployeeTO();
		e3Arg0.setUserid(61);
		e3Arg0.setEmail("Anu.R@gmail.com");
		Date e3Arg02Arg0 = new Date("04/04/1983");
		

		e3Arg0.setDob(e3Arg02Arg0);
		e3Arg0.setLastName("Ram");
		e3Arg0.setFirstName("Anu");
		DepartmentTO e3Arg05Arg0 = new DepartmentTO();
		e3Arg05Arg0.setDepartId(4);
		e3Arg0.setDepartment(e3Arg05Arg0);
		

		try{
			e0Obj.updateEmp(e3Arg0);
		}catch(Exception e){
			fail();
		}
		Date e4Arg0 =new Date("04/04/1981");
		Date e4Arg1 = new Date();

		boolean e4 = EmployeeBO.daysBetween(e4Arg0,e4Arg1);
		//TODO Based on your need, provide necessary assertion condition
		assertTrue(e4);
		try{
			EmployeeTO e5 = e0Obj.getEmpById(16);
			//TODO Based on your need, provide necessary assertion condition
		assertEquals("Preethi", e5.getFirstName());
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void addEmp(EmployeeTO)
	public void testAddEmpMin(){
		EmployeeBO e0Obj = new EmployeeBO();
		EmployeeTO e0Arg0 = new EmployeeTO();
		e0Arg0.setEmail(null);
		Date e0Arg02Arg0 = new Date("04/04/1983");
		

		e0Arg0.setDob(e0Arg02Arg0);
		e0Arg0.setLastName(null);
		e0Arg0.setFirstName(null);
		DepartmentTO e0Arg05Arg0 = new DepartmentTO();
		e0Arg05Arg0.setDepartId(1);
		

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
		EmployeeBO e0Obj = new EmployeeBO();
		try{
			e0Obj.deleteEmp(38);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void deleteEmp(int)
	public void testDeleteEmpMax(){
		EmployeeBO e0Obj = new EmployeeBO();
		try{
			e0Obj.deleteEmp(44);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void deleteEmp(int)
	public void testDeleteEmpNull(){
		EmployeeBO e0Obj = new EmployeeBO();
		try{
			e0Obj.deleteEmp(-76);
		}catch(Exception e){
			fail();
		}
	}
	

	@Test //public void deleteEmp(int)
	public void testDeleteEmpSplChar(){
		EmployeeBO e0Obj = new EmployeeBO();
		try{
			e0Obj.deleteEmp(49);
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
	

	@Test //public static long daysBetween(Calendar,Calendar)
	public void testDaysBetweenMin(){

		Date e0Arg0 =new Date("04/04/2013");
		Date e0Arg1 = new Date();

		boolean e0 = EmployeeBO.daysBetween(e0Arg0,e0Arg1);
		//TODO Based on your need, provide necessary assertion condition
		assertTrue(e0);
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
