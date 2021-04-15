package com.sample.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.sample.dao.Department;
import com.sample.dao.DepartmentDao;
import com.sample.exceptions.ApplicationException;
import com.sample.exceptions.BusinessException;
import com.sample.exceptions.DatabaseOperationException;
import com.sample.model.DepartmentTO;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentBO.
 */
public class DepartmentBO {
	
	/** The depart. */
	Department depart = new DepartmentDao();
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger("EmployeeBO");
	
	/**
	 * Adds the depart.
	 *
	 * @param departNm the depart nm
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 * @throws BusinessException the business exception
	 */
	public void addDepart(String departNm) throws DatabaseOperationException, ApplicationException, BusinessException {
			depart.addDepart(departNm);
		
	}
	
	/**
	 * Gets the all depart.
	 *
	 * @return the all depart
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	public List<DepartmentTO> getAllDepart() throws DatabaseOperationException, ApplicationException {
		return depart.getAllDepart();
	}
	
}
