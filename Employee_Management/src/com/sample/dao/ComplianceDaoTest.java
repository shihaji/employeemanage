package com.sample.dao;
import org.junit.Test;
import junit.framework.TestCase;

import com.sample.model.ComplianceTO;
import com.sample.model.DepartmentTO;
import com.sample.model.StatusReportTO;

import java.util.Date;
import java.util.List;
import com.sample.dao.DepartmentDao;


/** This class contains one testXXXX method per XXXXX method in source class
* @author 
**/
//TODO Add Junit jar in build path.
//TODO Modify input and output data if needed.


public class ComplianceDaoTest extends TestCase {
	

	/*@Test //public void addDepart(String)
	public void testcreateRL(){
		ComplianceDao e0Obj = new ComplianceDao();
		ComplianceTO ctobj=new ComplianceTO();
		DepartmentTO dtObj=new DepartmentTO();
		ctobj.setRlType("State");
		ctobj.setDetails("sfsdfsf");
		Date e0Arg03Arg0 = new Date("16/05/2013");//ctobj.setCreateDate("2013-05-15");
		ctobj.setCreateDate(e0Arg03Arg0);
		ctobj.setDepartment("10");
		
		try{
			e0Obj.createRL(ctobj);
		}catch(Exception e){
			fail();
		}
	}*/
	

	@Test //public List<DepartmentTO> getAllDepart()
	public void testgetAllRL(){
		ComplianceDao e0Obj = new ComplianceDao();
		ComplianceTO ctobj=new ComplianceTO();
		try{
			List<ComplianceTO> e0 = e0Obj.getAllRL("100");
			//TODO Based on your need, provide necessary assertion condition
			assertNotNull(e0);
		}catch(Exception e){
			fail();
		}
	}
	

	public void testinggetAllRL(){
		ComplianceDao e0Obj = new ComplianceDao();
		ComplianceTO ctobj=new ComplianceTO();
		try{
			List<ComplianceTO> e0 = e0Obj.getAllRL();
			//TODO Based on your need, provide necessary assertion condition
			assertNotNull(e0);
		}catch(Exception e){
			fail();
		}
	}

	public void testStatusreport(){
		ComplianceDao e0Obj = new ComplianceDao();
		StatusReportTO ctobj=new StatusReportTO();
		ctobj.setComplianceId(7);
		ctobj.setComments("test");
		Date e0Arg03Arg0 = new Date("11/17/1982");
		ctobj.setCreateDate(e0Arg03Arg0);
		ctobj.setDepartment("9");
		ctobj.setUserId("100");
		ctobj.setComplianceId(7);
		
		
		try{
			 e0Obj.createStatusReport(ctobj);
			//TODO Based on your need, provide necessary assertion condition
			assertNotNull(e0Obj);
		}catch(Exception e){
			fail();
		}
	}
	

	public void testAllStatusReport(){
		ComplianceDao e0Obj = new ComplianceDao();
		StatusReportTO ctobj=new StatusReportTO();
		ctobj.setComplianceId(9);
		try{
			List<StatusReportTO> e0 = e0Obj.getAllStatusReport("100",9);
			//TODO Based on your need, provide necessary assertion condition
			//assertNotNull(e0);
		}catch(Exception e){
			fail();
		}
	}
	

}
