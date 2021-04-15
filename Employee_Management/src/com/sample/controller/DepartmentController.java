package com.sample.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sample.bo.DepartmentBO;
import com.sample.constants.Constants;
import com.sample.constants.ErrorConstants;
import com.sample.exceptions.ApplicationException;
import com.sample.exceptions.BusinessException;
import com.sample.exceptions.DatabaseOperationException;
import com.sample.model.DepartmentTO;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentController.
 */
public class DepartmentController extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The view emp. */
	private static String viewDepart = "/department.jsp";

	/** The employee service. */
	private DepartmentBO departmentBO = new DepartmentBO();
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger("DepartmentController");
	/**
	 * Instantiates a new user controller.
	 */
	public DepartmentController() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOG.info("Inside - method doGet in DepartmentController class");
		try {
				List<DepartmentTO> departlist = departmentBO.getAllDepart();
				request.setAttribute("departments", departlist);
			
			RequestDispatcher view = request.getRequestDispatcher(viewDepart);
			LOG.info("Exit - method doGet in DepartmentController class");
			view.forward(request, response);
		} catch (DatabaseOperationException databaseOperationException) {
			LOG.info("DepartmentController class - Exception"+databaseOperationException.getMessage());
			request.setAttribute("message",Constants.EXCEPTION);
			// as attribute to the request
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);// forwards the request to
			// error.jsp in case of login failure or any exception
		} catch (ApplicationException applicationException) {
			// TODO Auto-generated catch block
			LOG.info("DepartmentController class - Exception"+applicationException.getMessage());
			request.setAttribute("message", Constants.EXCEPTION);
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);
		} 
		catch (Exception exception) {
			LOG.info("DepartmentController class - Exception"+exception.getMessage());
			request.setAttribute("message", Constants.EXCEPTION);
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOG.info("Inside - method doPost in DepartmentController class");
		try {
				String departNm = request.getParameter("departName");
				departmentBO.addDepart(departNm);
				List<DepartmentTO> departlist = departmentBO.getAllDepart();
				request.setAttribute("departments", departlist);
				RequestDispatcher view = request.getRequestDispatcher(viewDepart);
				LOG.info("Exit - method doPost in DepartmentController class");
			view.forward(request, response);
		} catch (DatabaseOperationException databaseOperationException) {
			LOG.info("DepartmentController class - Exception"+databaseOperationException.getMessage());
			request.setAttribute("message",Constants.EXCEPTION);
			// as attribute to the request
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);// forwards the request to
			// error.jsp in case of login failure or any exception
		} catch (ApplicationException applicationException) {
			LOG.info("DepartmentController class - Exception"+applicationException.getMessage());
			// TODO Auto-generated catch block
			request.setAttribute("message", Constants.EXCEPTION);
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);
		} catch (BusinessException businessException) {
			LOG.info("DepartmentController class - Exception"+businessException.getMessage());
			request.setAttribute("message", Constants.EXCEPTION);
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);
		}
		catch (Exception exception) {
			LOG.info("DepartmentController class - Exception"+exception.getMessage());
			request.setAttribute("message", Constants.EXCEPTION);
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);
		}
		
	}
}
