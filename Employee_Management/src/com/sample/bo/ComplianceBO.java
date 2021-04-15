package com.sample.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sample.constants.Constants;
import com.sample.dao.Compliance;
import com.sample.dao.ComplianceDao;
import com.sample.exceptions.ApplicationException;
import com.sample.exceptions.BusinessException;
import com.sample.exceptions.DatabaseOperationException;
import com.sample.model.ComplianceTO;
import com.sample.model.StatusReportTO;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentBO.
 */
public class ComplianceBO {
	
	/** The depart. */
	Compliance compliance = new ComplianceDao();
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger("EmployeeBO");
	

	public void createRL(ComplianceTO complianceTO ) throws DatabaseOperationException, ApplicationException, BusinessException {
		compliance.createRL(complianceTO);
		
	}

	/**
	 * Gets the all rl.
	 *
	 * @return the all rl
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	public List<ComplianceTO> getAllRL() throws DatabaseOperationException, ApplicationException {
		List<ComplianceTO> complianceList =compliance.getAllRL();
		for(int i=0;i<complianceList.size();i++){
			ComplianceTO complianceTO =complianceList.get(i);
			if(complianceTO.getEmpCount()==complianceTO.getStsCount()){
				complianceTO.setStatus(Constants.CLOSED);
				
			}
			else{
				complianceTO.setStatus(Constants.OPEN);
			}
		}
		return complianceList;
	}
	
	/**
	 * Gets the all rl.
	 *
	 * @param userId the user id
	 * @return the all rl
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	public List<ComplianceTO> getAllRL(String userId) throws DatabaseOperationException, ApplicationException {
		
		return compliance.getAllRL(userId);
	}
	
	/**
	 * Creates the status report.
	 *
	 * @param statusReportTO the status report to
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 * @throws BusinessException the business exception
	 */
	public void createStatusReport(StatusReportTO statusReportTO ) throws DatabaseOperationException, ApplicationException, BusinessException {
		compliance.createStatusReport(statusReportTO);
		
	}
	
	/**
	 * Gets the all status report.
	 *
	 * @param userId the user id
	 * @return the all status report
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	public List<StatusReportTO> getAllStatusReport(String userId,int complainceID) throws DatabaseOperationException, ApplicationException {
		return compliance.getAllStatusReport(userId,complainceID);
	}
}
