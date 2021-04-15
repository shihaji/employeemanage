package com.sample.dao;

import java.util.List;

import com.sample.exceptions.ApplicationException;
import com.sample.exceptions.DatabaseOperationException;
import com.sample.model.ComplianceTO;
import com.sample.model.StatusReportTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface Department.
 */
public interface Compliance {

	/**
	 * Creates the rl.
	 *
	 * @param complianceTO the compliance to
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	void createRL(ComplianceTO complianceTO) throws DatabaseOperationException, ApplicationException;
	
	/**
	 * Gets the all rl.
	 *
	 * @return the all rl
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	public List<ComplianceTO> getAllRL() throws DatabaseOperationException, ApplicationException;
	public List<Integer> getStatusList() throws DatabaseOperationException, ApplicationException;
	
	/**
	 * Gets the all rl.
	 *
	 * @param userId the user id
	 * @return the all rl
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	public List<ComplianceTO> getAllRL(String userId) throws DatabaseOperationException, ApplicationException;
	
	/**
	 * Creates the status report.
	 *
	 * @param statusReportTO the status report to
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	public void createStatusReport(StatusReportTO statusReportTO) throws DatabaseOperationException, ApplicationException;
	
	/**
	 * Gets the all status report.
	 *
	 * @param userId the user id
	 * @param complianceID the compliance id
	 * @return the all status report
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	public List<StatusReportTO> getAllStatusReport(String userId,int complianceID) throws DatabaseOperationException, ApplicationException;
}
