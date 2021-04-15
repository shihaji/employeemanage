package com.sample.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.sample.constants.ErrorConstants;
import com.sample.constants.SuccessConstants;
import com.sample.bo.LoginBO;
import com.sample.exceptions.BusinessException;
import com.sample.exceptions.ApplicationException;
import com.sample.exceptions.DatabaseOperationException;
import com.sample.model.UserTO;
import com.sample.util.PropertyUtil;

/**
 * Servlet implementation class LoginServlet This Servlet acts as the controller
 * for the login process.This is called when the user submits the login.jsp
 * page.
 */
public class LoginController extends HttpServlet {
	/**
	 * serialVersionUID value for the serializable class
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The Logger for logging the errors and info
	 */
	public static final Logger LOG = Logger.getLogger("LoginController");

	// Logger object used for logging the errors and info

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		UserTO user = new UserTO();
		final String userid = request.getParameter("userid");// Username entered
		// by the user in the login page
		final String passWord = request.getParameter("password");// Password entered
		// by the user in the login page
		user.setUserid(userid);
		user.setPassword(passWord);
		
		LOG.info("Login servlet invoked UserName:" + userid + "Password:"
				+ passWord);
		 HttpSession session = request.getSession(true);

		final LoginBO logic = new LoginBO();// Creates an Object of LoginBO
		try {
			user = logic.validateUser(user);// Calls the validateUser method of the
			// LoginBO
		//	request.setAttribute("message", PropertyUtil
	//				.getSuccessMessage(SuccessConstants.LOGINSUCCESS));// Sets the message as
			// attribute to the request
			session.setAttribute("Role", user.getRole());
			session.setAttribute("UserID", user.getUserid());
			RequestDispatcher dispatcher = null;
			if(user.getRole()!=null && user.getRole().trim().equals("ADMIN")){
				dispatcher = request
					.getRequestDispatcher(SuccessConstants.SUCCESSPAGE);
			}
			else{
				dispatcher = request
				.getRequestDispatcher(SuccessConstants.SUCCESSPAGE_USER);
			}
			dispatcher.forward(request, response); // forwards the request to
			// implementation.jsp since the user has successfully logged in
			
		} catch (BusinessException businessException) {
			LOG.error("Exception occured while logging", businessException.getCause());
			request.setAttribute("message", businessException.getMessage());// Sets the message
			// as attribute to the request
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.LOGINPAGE);
			dispatcher.forward(request, response);// forwards the request to
			// error.jsp in case of login failure or any exception
		} catch (DatabaseOperationException databaseOperationException) {// Handles the LoginExceptions and log the
			// errors into the Log
			request
					.setAttribute("message", PropertyUtil
							.getErrorMessage(ErrorConstants.FATALERROR));
			LOG.error("Exception occured when processing validate user:"
					+ databaseOperationException.getCause());
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);
		} catch (ApplicationException applicationException) {
			// TODO Auto-generated catch block
			request
			.setAttribute("message", PropertyUtil
					.getErrorMessage(ErrorConstants.FATALERROR));
			LOG.error("Exception occured when processing validate user:"
					+ applicationException.getCause());
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);
		}
		 catch (Exception exception) {
				// TODO Auto-generated catch block
				request
				.setAttribute("message", PropertyUtil
						.getErrorMessage(ErrorConstants.FATALERROR));
				LOG.error("Exception occured when processing validate user:"
						+ exception.getCause());
				final RequestDispatcher dispatcher = request
						.getRequestDispatcher(ErrorConstants.ERRORPAGE);
				dispatcher.forward(request, response);
			}

	}

}
