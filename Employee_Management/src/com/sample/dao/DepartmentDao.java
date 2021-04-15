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
import com.sample.model.DepartmentTO;
import com.sample.util.DbUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentDao.
 */
public class DepartmentDao implements Department{
	
	/** The connection. */
	private Connection connection;
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger("DepartmentDao");
	
	/**
	 * ****************************************************************
	 * This method is used to store the department details in DB.
	 *
	 * @param departNm -Department Name
	 * @throws DatabaseOperationException when any SQLException occurs in the system
	 * @throws ApplicationException *****************************************************************
	 */
	public void addDepart(String departNm) throws DatabaseOperationException, ApplicationException {
		PreparedStatement preparedStatement = null;
		try {
			LOG.info("Inside - method addDepart in DepartmentDao class");
			connection = DbUtil.getConnection();
			preparedStatement = connection
					.prepareStatement(QueryConstants.CREATE_DEPARTMENT);
			preparedStatement.setString(1, departNm);
			preparedStatement.executeUpdate();
			LOG.info("Exit - method addDepart in DepartmentDao class");
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
	 * This method is used to get all the department details.
	 *
	 * @return the all depart
	 * @throws DatabaseOperationException when any SQLException occurs in the system
	 * @throws ApplicationException *****************************************************************
	 */
	public List<DepartmentTO> getAllDepart() throws DatabaseOperationException, ApplicationException {
		LOG.info("Inside - method getAllDepart in DepartmentDao class");
		List<DepartmentTO> departlist = new ArrayList<DepartmentTO>();
		ResultSet rs=null;
		Statement statement=null;
		try {
			connection = DbUtil.getConnection();
			statement = connection.createStatement();
			 rs = statement.executeQuery(QueryConstants.SELECT_DEPT);
			while (rs.next()) {
				DepartmentTO depart = new DepartmentTO();
				depart.setDepartId(rs.getInt("department_id"));
				depart.setDepartName(rs.getString("department_nm"));
				departlist.add(depart);
			}
			LOG.info("Exit - method getAllDepart in DepartmentDao class");
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
				if(rs!=null){
					rs.close();
				}
				statement.close();
				if(connection!=null)
				{
					connection.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(
						sqlException);
			}
		}
		return departlist;
	}
}
