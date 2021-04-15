package com.sample.bo;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.sample.constants.ErrorConstants;
import com.sample.dao.Employee;
import com.sample.dao.EmployeeDao;
import com.sample.exceptions.ApplicationException;
import com.sample.exceptions.BusinessException;
import com.sample.exceptions.DatabaseOperationException;
import com.sample.model.EmployeeTO;
import com.sample.util.PropertyUtil;

;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeService.
 */
public class EmployeeBO {

	/** The emp. */
	Employee emp = new EmployeeDao();
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger("EmployeeBO");
	
	/**
	 * Adds the emp.
	 *
	 * @param employee the employee
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 * @throws BusinessException the business exception
	 */
	public void addEmp(EmployeeTO employee) throws DatabaseOperationException, ApplicationException, BusinessException {
		String message = null;
		boolean valid = daysBetween(employee.getDob(),new Date());
		if(valid){
			emp.addEmp(employee);
		}
		else{
			message = PropertyUtil.getErrorMessage(ErrorConstants.INVALID_YEAR);
			LOG.debug("Message" + message);
			throw new BusinessException(message);
		}
	}

	/**
	 * Delete emp.
	 *
	 * @param empId the emp id
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	public void deleteEmp(int empId) throws DatabaseOperationException, ApplicationException {
		emp.deleteEmp(empId);
	}

	/**
	 * Update emp.
	 *
	 * @param employee the employee
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 * @throws BusinessException the business exception
	 */
	public void updateEmp(EmployeeTO employee)
			throws DatabaseOperationException, ApplicationException, BusinessException {
		String message = null;
		boolean valid = daysBetween(employee.getDob(),new Date());
		if(valid){
		emp.updateEmp(employee);
		}
		else{
			message = PropertyUtil.getErrorMessage(ErrorConstants.INVALID_YEAR);
			LOG.debug("Message" + message);
			throw new BusinessException(message);
		}
	}

	/**
	 * Gets the all emp.
	 *
	 * @return the all emp
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	public List<EmployeeTO> getAllEmp() throws DatabaseOperationException, ApplicationException {
		return emp.getAllEmp();
	}

	/**
	 * Gets the emp by id.
	 *
	 * @param userId the user id
	 * @return the emp by id
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	public EmployeeTO getEmpById(int userId) throws DatabaseOperationException, ApplicationException {
		return emp.getEmpById(userId);
	}
	
	/**
	 * Days between.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the long
	 */
	@SuppressWarnings("deprecation")
	public static boolean daysBetween(Date startDate, Date endDate) {  
		  /*Calendar date = (Calendar) startDate.clone();  
		  long daysBetween = 0;  
		  long diff = endDate.getTimeInMillis() - startDate.getTimeInMillis();
          daysBetween = (long) diff / (24 * 60 * 60 * 1000);
		  return daysBetween;*/
        int age = endDate.getYear() - startDate.getYear();
        if (endDate.getMonth() < startDate.getMonth() || (endDate.getMonth() == startDate.getMonth() && endDate.getDay() < startDate.getDay()))
            age--;

            if (age > 24) {
            	return true; 
            	} else {
            	return false; 
            	}

		} 
}
