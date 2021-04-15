package com.sample.dao;

import java.util.List;

import com.sample.exceptions.ApplicationException;
import com.sample.exceptions.DatabaseOperationException;
import com.sample.model.DepartmentTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface Department.
 */
public interface Department {
	
	/**
	 * Adds the depart.
	 *
	 * @param departNm the depart nm
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	void addDepart(String departNm) throws DatabaseOperationException, ApplicationException;
	
	/**
	 * Gets the all depart.
	 *
	 * @return the all depart
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	List<DepartmentTO> getAllDepart() throws DatabaseOperationException, ApplicationException;

}
