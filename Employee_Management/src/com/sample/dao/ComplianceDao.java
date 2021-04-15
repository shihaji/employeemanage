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

import com.sample.constants.QueryConstants;
import com.sample.exceptions.ApplicationException;
import com.sample.exceptions.DatabaseOperationException;
import com.sample.model.ComplianceTO;
import com.sample.model.DepartmentTO;
import com.sample.model.StatusReportTO;
import com.sample.util.DbUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentDao.
 */
public class ComplianceDao implements Compliance{
	
	/** The connection. */
	private Connection connection;
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger("ComplianceDao");
	
	/**
	 * ****************************************************************
	 * This method is used to store the RL details in DB.
	 *
	 * @param ComplianceTO complianceTO
	 * @throws DatabaseOperationException when any SQLException occurs in the system
	 * @throws ApplicationException *****************************************************************
	 */
	public void createRL(ComplianceTO complianceTO) throws DatabaseOperationException, ApplicationException {
		PreparedStatement preparedStatement = null;
		try {
			LOG.info("Inside - method createRL in ComplianceDAO class");
			connection = DbUtil.getConnection();
			preparedStatement = connection
					.prepareStatement(QueryConstants.CREATE_RL);
			preparedStatement.setString(1, complianceTO.getRlType());
			preparedStatement.setString(2, complianceTO.getDetails());
			preparedStatement.setDate(3, new java.sql.Date( complianceTO.getCreateDate().getTime()));
			preparedStatement.setInt(4, complianceTO.getDepartment().getDepartId());
			preparedStatement.executeUpdate();
			LOG.info("Exit - method createRL in ComplianceDAO class");
		} catch (SQLException sqlException) {
			throw new DatabaseOperationException(
					sqlException);

		} catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		}finally {

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
	 * This method is used to get all the rl details.
	 *
	 * @return the all rl created
	 * @throws DatabaseOperationException when any SQLException occurs in the system
	 * @throws ApplicationException *****************************************************************
	 */
	public List<ComplianceTO> getAllRL() throws DatabaseOperationException, ApplicationException {
		LOG.info("Inside - method getAllRL in ComplianceDAO class");
		List<ComplianceTO> complianceList = new ArrayList<ComplianceTO>();
		ResultSet rs=null;
		Statement statement = null;
		try {
			connection = DbUtil.getConnection();
			 statement = connection.createStatement();
			 rs = statement.executeQuery(QueryConstants.SELECT_RL);
			while (rs.next()) {
				ComplianceTO complainceTO = new ComplianceTO();
				complainceTO.setComplainceId(rs.getInt("complianceid"));
				complainceTO.setRlType(rs.getString("rlType"));
				complainceTO.setDetails(rs.getString("details"));
				complainceTO.setCreateDate(rs.getDate("createDate"));
				DepartmentTO depart = new DepartmentTO();
				depart.setDepartId(rs.getInt("department_id"));
				depart.setDepartName(rs.getString("department_nm"));
				complainceTO.setDepartment(depart);
				complainceTO.setEmpCount(rs.getInt("empcount"));
				complainceTO.setStsCount(rs.getInt("statuscount"));
				complianceList.add(complainceTO);
			}
			LOG.info("Exit - method getAllRL in ComplianceDAO class");
		} catch (SQLException sqlException) {
			throw new DatabaseOperationException(
					sqlException);

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
		return complianceList;
	}
	
	public List<Integer> getStatusList() throws DatabaseOperationException, ApplicationException
	{

		LOG.info("Inside - method getAllRL in ComplianceDAO class");
		List<Integer> complianceList = new ArrayList<Integer>();
		ResultSet rs=null;
		Statement statement=null;
		try {
			connection = DbUtil.getConnection();
			statement = connection.createStatement();
			 rs = statement.executeQuery(QueryConstants.CREATE_STATUS);
			while (rs.next()) {
				complianceList.add(rs.getInt("complianceid"));
			}
			LOG.info("Exit - method getAllRL in ComplianceDAO class");
		} catch (SQLException sqlException) {
			throw new DatabaseOperationException(
					sqlException);

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
		return complianceList;
	
		
	}
	
	/**
	 * ****************************************************************
	 * This method is used to get all the rl details for a user belonging to a department.
	 *
	 * @return the all rl created
	 * @throws DatabaseOperationException when any SQLException occurs in the system
	 * @throws ApplicationException *****************************************************************
	 */
	public List<ComplianceTO> getAllRL(String userId) throws DatabaseOperationException, ApplicationException {
		LOG.info("Inside - method getAllRL in ComplianceDAO class");
		List<ComplianceTO> complianceList = new ArrayList<ComplianceTO>();
		ResultSet rs=null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DbUtil.getConnection();
			preparedStatement = connection
						.prepareStatement(QueryConstants.SELECT_RL_USER);
				preparedStatement.setString(1, userId);
				rs = preparedStatement.executeQuery();
			while (rs.next()) {
				ComplianceTO complainceTO = new ComplianceTO();
				complainceTO.setComplainceId(rs.getInt("complianceid"));
				complainceTO.setRlType(rs.getString("rlType"));
				complainceTO.setCreateDate(rs.getDate("createDate"));
				complainceTO.setDetails(rs.getString("details"));
				DepartmentTO depart = new DepartmentTO();
				depart.setDepartId(rs.getInt("department_id"));
				depart.setDepartName(rs.getString("department_nm"));
				complainceTO.setDepartment(depart);
				complianceList.add(complainceTO);
			}
			LOG.info("Exit - method getAllRL in ComplianceDAO class");
		} catch (SQLException sqlException) {
			throw new DatabaseOperationException(
					sqlException);

		} catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		}
		finally {

			try {
				preparedStatement.close();
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
		return complianceList;
	}
	/**
	 * ****************************************************************
	 * This method is used to store the Status Report details in DB.
	 *
	 * @param StatusReportTO statusReportTO
	 * @throws DatabaseOperationException when any SQLException occurs in the system
	 * @throws ApplicationException *****************************************************************
	 */
	public void createStatusReport(StatusReportTO statusReportTO) throws DatabaseOperationException, ApplicationException {
		ResultSet rs=null;
		int departId=0;
		PreparedStatement preparedStatement =null;
		try {
			LOG.info("Inside - method createStatusReport in ComplianceDAO class");
			connection = DbUtil.getConnection();
			 preparedStatement = connection
			.prepareStatement(QueryConstants.SELECT_DEPARTMENT);
			preparedStatement.setInt(1, statusReportTO.getComplianceId());
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				departId = rs.getInt("department_id");
			}
			preparedStatement.close();
			preparedStatement = connection
					.prepareStatement(QueryConstants.CREATE_STATUSREPORT);
			preparedStatement.setString(1, statusReportTO.getComments());
			preparedStatement.setDate(2, new java.sql.Date( statusReportTO.getCreateDate().getTime()));
			preparedStatement.setInt(3,departId);
			preparedStatement.setString(4, statusReportTO.getUserId());
			preparedStatement.setInt(5, statusReportTO.getComplianceId());
			preparedStatement.executeUpdate();
			LOG.info("Exit - method createStatusReport in ComplianceDAO class");
		} catch (SQLException sqlException) {
			throw new DatabaseOperationException(
					sqlException);

		} catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		}finally {

			try {
				preparedStatement.close();
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
	}
	/**
	 * ****************************************************************
	 * This method is used to get all the status report details for a user belonging to a department.
	 *
	 * @return the all status report created
	 * @throws DatabaseOperationException when any SQLException occurs in the system
	 * @throws ApplicationException *****************************************************************
	 */
	public List<StatusReportTO> getAllStatusReport(String userId,int complianceID) throws DatabaseOperationException, ApplicationException {
		LOG.info("Inside - method getAllRL in ComplianceDAO class");
		List<StatusReportTO> statusReportList = new ArrayList<StatusReportTO>();
		ResultSet rs=null;
		PreparedStatement preparedStatement=null;
		try {
			connection = DbUtil.getConnection();
			 preparedStatement = connection
						.prepareStatement(QueryConstants.SELECT_STATUSREPORT);
				preparedStatement.setString(1, userId);
				preparedStatement.setInt(2, complianceID);
				rs = preparedStatement.executeQuery();
			while (rs.next()) {
				StatusReportTO statusReportTO = new StatusReportTO();
				statusReportTO.setStatusId(rs.getInt("statusrptid"));
				statusReportTO.setComments(rs.getString("comments"));
				statusReportTO.setCreateDate(rs.getDate("createDate"));
				DepartmentTO depart = new DepartmentTO();
				depart.setDepartId(rs.getInt("department_id"));
				depart.setDepartName(rs.getString("department_nm"));
				statusReportTO.setDepartment(depart);
				statusReportList.add(statusReportTO);
			}
			LOG.info("Exit - method getAllRL in ComplianceDAO class");
		} catch (SQLException sqlException) {
			throw new DatabaseOperationException(
					sqlException);

		} catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		}
		finally {

			try {
				preparedStatement.close();
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
		return statusReportList;
	}
}
