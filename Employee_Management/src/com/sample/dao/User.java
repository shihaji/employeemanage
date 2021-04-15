package com.sample.dao;



import com.sample.exceptions.ApplicationException;


import com.sample.model.UserTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface Employee.
 */
public interface User {
	  
	/**
	 * Gets the user details.
	 *
	 * @param user the user
	 * @return the user details
	 * @throws ApplicationException the application exception
	 */
	public UserTO getUserDetails(final UserTO user) throws ApplicationException; 
}
