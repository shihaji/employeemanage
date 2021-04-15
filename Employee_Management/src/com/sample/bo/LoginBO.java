package com.sample.bo;

import org.apache.log4j.Logger;

import com.sample.constants.ErrorConstants;
import com.sample.dao.User;
import com.sample.dao.UserDao;
import com.sample.exceptions.ApplicationException;
import com.sample.exceptions.BusinessException;
import com.sample.exceptions.DatabaseOperationException;
import com.sample.model.UserTO;
import com.sample.util.PropertyUtil;

/**
 *  The LoginBO class contains the logic for validating the
 *         user's login
 * @author t-Renjith
 */
public class LoginBO {
	/**
	 * The log object used for logging the error and info
	 */
	User userdao = new UserDao();
	
	public static final Logger LOG = Logger.getLogger("LoginBO");

	/**
	 * @param user
	 *            -The UserVO object which contains the user details
	 * @return true if no exception is thrown
	 * @throws ApplicationException 
	 * @throws LoginBusinessException
	 *             -Thrown when the login fails
	 * @throws LoginException
	 *             -Thrown in case of any fatal exception occurring in the
	 *             system
	 */
	public UserTO validateUser(UserTO userTO)
			throws BusinessException, DatabaseOperationException, ApplicationException {

		String message = null;// Variable used for storing the messages.
		int flag = 0; // Flag variable for holding the value returned from the
		// UserDao which says whether the username or password
		// is incorrect

		LOG.info("Method Validate User Invoked" + userTO);
		userdao.getUserDetails(userTO);
		LOG.debug("Authentication flag" + flag);

		if (userTO.getResult() == 0) {
			message = PropertyUtil.getErrorMessage(ErrorConstants.INVALIDUSERNAME);
			LOG.debug("Message" + message);
			throw new BusinessException(message);
		} else if (userTO.getResult() == 1) {
			message = PropertyUtil.getErrorMessage(ErrorConstants.INVALIDPASSWORD);
			LOG.debug("Message" + message);
			throw new BusinessException(message);
		}
		LOG.info("Validate User: Response true");
		return userTO;
	}
}
