package com.sample.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sample.constants.Constants;
import com.sample.constants.ErrorConstants;
import com.sample.constants.QueryConstants;
import com.sample.exceptions.ApplicationException;
import com.sample.exceptions.DatabaseOperationException;
import com.sample.model.DepartmentTO;
import com.sample.model.EmployeeTO;
import com.sample.util.DbUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeDao manages the DB operations for employee object.
 */
public class EmployeeDao implements Employee {

	/** The connection. */
	private Connection connection;
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger("EmployeeDao");


	/**
	 * Instantiates a new employee dao.
	 */
	public EmployeeDao() {
		
	}

	/**
	 * ****************************************************************
	 * This method is used to store the employee details in DB.
	 *
	 * @param employee -The EmployeeTO object holds the employee info that needs to be stored
	 * @throws DatabaseOperationException when any SQLException occurs in the system
	 * @throws ApplicationException *****************************************************************
	 */
	public void addEmp(EmployeeTO employee) throws DatabaseOperationException, ApplicationException {
		PreparedStatement preparedStatement=null;
		try {
			LOG.info("Inside - method addEmp in EmployeeDao class");
			connection = DbUtil.getConnection();
			preparedStatement = connection
					.prepareStatement(QueryConstants.CREATE_EMPLOYEE);
			// Parameters start with 1
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(employee.getDob()
					.getTime()));
			preparedStatement.setString(4, employee.getEmail());
			preparedStatement.setInt(5, employee.getDepartment().getDepartId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			preparedStatement = connection
			.prepareStatement(QueryConstants.CREATE_LOGIN);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, Constants.DEFAULT_PASSWORD);
			preparedStatement.setString(4, Constants.DEFAULT_ROLE);	
			preparedStatement.executeUpdate();
			LOG.info("Exit - method addEmp in EmployeeDao class");
		} catch (SQLException sqlException) {
			throw new DatabaseOperationException(sqlException);

		} catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		}
		finally {

			try {
				preparedStatement.close();
				if(connection!=null)
				{
					connection.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(
						sqlException);
			}
		}
	}

	/**
	 * ****************************************************************
	 * This method is used to delete the selected Employee details.
	 *
	 * @param empId -Employee Id of the person whose details need to be deleted
	 * @throws DatabaseOperationException when any SQLException occurs in the system
	 * @throws ApplicationException *****************************************************************
	 */
	public void deleteEmp(int empId) throws DatabaseOperationException, ApplicationException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		int count = 0;
		try {
			LOG.info("Inside - method deleteEmp in EmployeeDao class");
			connection = DbUtil.getConnection();
			preparedStatement = connection
			.prepareStatement(QueryConstants.CHK_STATUS);
			// Parameters start with 1
			preparedStatement.setInt(1, empId);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				count =rs.getInt("count");
			}
			preparedStatement.close();
			if(count==0){
			preparedStatement = connection
			.prepareStatement(QueryConstants.DELETE_EMP_LOGIN);
			// Parameters start with 1
			preparedStatement.setInt(1, empId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			preparedStatement = connection
					.prepareStatement(QueryConstants.DELETE_EMP);
			// Parameters start with 1
			preparedStatement.setInt(1, empId);
			preparedStatement.executeUpdate();
			}
			LOG.info("Exit - method deleteEmp in EmployeeDao class");

		} catch (SQLException sqlException) {
			throw new DatabaseOperationException(sqlException);

		} catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		}
		finally {

			try {
				preparedStatement.close();
				if(connection!=null)
				{
					connection.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(
						sqlException);
			}
		}
	}

	/**
	 * ****************************************************************
	 * This method is used to update the Employee details.
	 *
	 * @param employee the employee
	 * @throws DatabaseOperationException when any SQLException occurs in the system
	 * @throws ApplicationException *****************************************************************
	 */
	public void updateEmp(EmployeeTO employee)
			throws DatabaseOperationException, ApplicationException {
		PreparedStatement preparedStatement=null;
		try {
			LOG.info("Inside - method updateEmp in EmployeeDao class");
			connection = DbUtil.getConnection();
			preparedStatement = connection
					.prepareStatement(QueryConstants.UPDATE_EMP);
			// Parameters start with 1
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(employee.getDob()
					.getTime()));
			preparedStatement.setString(4, employee.getEmail());
			preparedStatement.setInt(5, employee.getDepartment().getDepartId());
			preparedStatement.setInt(6, employee.getUserid());
			preparedStatement.executeUpdate();
			LOG.info("Exit - method updateEmp in EmployeeDao class");

		} catch (SQLException sqlException) {
			throw new DatabaseOperationException(sqlException);

		}catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		}
		finally {
			try {
				preparedStatement.close();
				if(connection!=null)
				{
					connection.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(
						sqlException);
			}
		}
	}

	/**
	 * ****************************************************************
	 * This method is used to get all the employee details.
	 *
	 * @return the all emp
	 * @throws DatabaseOperationException when any SQLException occurs in the system
	 * @throws ApplicationException *****************************************************************
	 */
	public List<EmployeeTO> getAllEmp() throws DatabaseOperationException, ApplicationException {
		LOG.info("Inside - method getAllEmp in EmployeeDao class");
		List<EmployeeTO> employees = new ArrayList<EmployeeTO>();
		ResultSet rs = null;
		Statement statement=null;
		try {
			connection = DbUtil.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(QueryConstants.SELECT_EMP);
			while (rs.next()) {
				EmployeeTO employee = new EmployeeTO();
				DepartmentTO depart = new DepartmentTO();
				employee.setUserid(rs.getInt("empid"));
				employee.setFirstName(rs.getString("firstname"));
				employee.setLastName(rs.getString("lastname"));
				employee.setDob(rs.getDate("dob"));
				employee.setEmail(rs.getString("email"));
				depart.setDepartName(rs.getString("department_nm"));
				employee.setDepartment(depart);
				employees.add(employee);
			}
			LOG.info("Exit - method getAllEmp in EmployeeDao class");
		} catch (SQLException sqlException) {
			throw new DatabaseOperationException(sqlException);

		} catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		}
		finally {

			try {
				statement.close();
				if(rs!=null){
					rs.close();
				}
				if(connection!=null)
				{
					connection.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(
						sqlException);
			}
		}
		return employees;
	}


	/**
	 * ****************************************************************
	 * This method is used to get the selected employee details.
	 *
	 * @param userId - User Id of the selected employee
	 * @return the selected employee details
	 * @throws DatabaseOperationException when any SQLException occurs in the system
	 * @throws ApplicationException *****************************************************************
	 */
	public EmployeeTO getEmpById(int userId) throws DatabaseOperationException, ApplicationException {
		LOG.info("Inside - method getEmpById in EmployeeDao class");
		EmployeeTO employee = new EmployeeTO();
		ResultSet rs=null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DbUtil.getConnection();
			preparedStatement = connection
					.prepareStatement(QueryConstants.GET_EMPDTL);
			preparedStatement.setInt(1, userId);
			 rs = preparedStatement.executeQuery();

			if (rs.next()) {
				DepartmentTO departmentTO = new DepartmentTO();
				employee.setUserid(rs.getInt("empid"));
				employee.setFirstName(rs.getString("firstname"));
				employee.setLastName(rs.getString("lastname"));
				employee.setDob(rs.getDate("dob"));
				employee.setEmail(rs.getString("email"));
				departmentTO.setDepartId(rs.getInt("depart_id"));
				departmentTO.setDepartName(rs.getString("department_nm"));
				employee.setDepartment(departmentTO);
			}
		} catch (SQLException sqlException) {
			throw new DatabaseOperationException(ErrorConstants.ERRORCODE,
					sqlException);
		} catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		}
		finally {

			try {
				if(rs!=null){
					rs.close();
				}
				if(connection!=null)
				{
					connection.close();
				}
				preparedStatement.close();
			} catch (SQLException sqlException) {
				new DatabaseOperationException(
						sqlException);
			}
		}
		LOG.info("Exit - method getEmpById in EmployeeDao class");
		return employee;
	}
}
