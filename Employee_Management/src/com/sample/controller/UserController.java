package com.sample.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sample.bo.DepartmentBO;
import com.sample.bo.EmployeeBO;
import com.sample.constants.Constants;
import com.sample.constants.ErrorConstants;
import com.sample.exceptions.ApplicationException;
import com.sample.exceptions.BusinessException;
import com.sample.exceptions.DatabaseOperationException;
import com.sample.model.DepartmentTO;
import com.sample.model.EmployeeTO;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
public class UserController extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The insertedit. */
	private static String insertedit = "/user.jsp";

	/** The view emp. */
	private static String viewEmp = "/listUser.jsp";

	/** The employee service. */
	private EmployeeBO employeeBO = new EmployeeBO();
	
	/** The department bo. */
	private DepartmentBO departmentBO = new DepartmentBO();
	/**
	 * Instantiates a new user controller.
	 */
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger("UserController");
	public UserController() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		String forward = "";
		try {
			LOG.info("Inside - method doGet in UserController class");
			final String action = request.getParameter("action");
			List<DepartmentTO> departlist = departmentBO.getAllDepart();
			if (action.equalsIgnoreCase("delete")) {
				final int empId = Integer.parseInt(request
						.getParameter("userId"));
				employeeBO.deleteEmp(empId);
				forward = viewEmp;
				request.setAttribute("employees", employeeBO.getAllEmp());
			} else if (action.equalsIgnoreCase("edit")) {
				forward = insertedit;
				int userId = Integer.parseInt(request.getParameter("userId"));
				EmployeeTO employee = employeeBO.getEmpById(userId);
				request.setAttribute("employee", employee);
			} else if (action.equalsIgnoreCase("listUser")) {
				forward = viewEmp;
				request.setAttribute("employees", employeeBO.getAllEmp());
			} else {
				forward = insertedit;
			}
			RequestDispatcher view = request.getRequestDispatcher(forward);
			request.setAttribute("departments", departlist);
			view.forward(request, response);
			LOG.info("Exit - method doGet in UserController class");
		} catch (DatabaseOperationException dbException) {
			LOG.info("UserController class - DatabaseOperationException"+dbException.getMessage());
			request.setAttribute("message",
					Constants.EXCEPTION);
			// as attribute to the request
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);// forwards the request to
			// error.jsp in case of login failure or any exception
		} catch (ApplicationException appException) {
			LOG.info("UserController class - ApplicationException"+appException.getMessage());
			// TODO Auto-generated catch block
			request.setAttribute("message", Constants.EXCEPTION);
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);
		}catch (Exception exception) {
			LOG.info("UserController class - ApplicationException"+exception.getMessage());
			// TODO Auto-generated catch block
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
		LOG.info("Inside - method doPost in UserController class");
		try {
			final String action = request.getParameter("action");
			if(action==null){
			EmployeeTO employeeTO = new EmployeeTO();
			DepartmentTO departmentTO = new DepartmentTO();
			employeeTO.setFirstName(request.getParameter("firstName"));
			employeeTO.setLastName(request.getParameter("lastName"));

			Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request
					.getParameter("dob"));
			employeeTO.setDob(dob);

			employeeTO.setEmail(request.getParameter("email"));
			departmentTO.setDepartId(Integer.parseInt(request.getParameter("deptId")));
			departmentTO.setDepartName(request.getParameter("deptNm"));
			employeeTO.setDepartment(departmentTO);
			String userid = request.getParameter("userid");
			List<DepartmentTO> departlist = departmentBO.getAllDepart();
			request.setAttribute("departments", departlist);
			
			request.setAttribute("employee", employeeTO);
			if (userid == null || userid.isEmpty()) {
				
				employeeBO.addEmp(employeeTO);
			} else {
				employeeTO.setUserid(Integer.parseInt(userid));
				employeeBO.updateEmp(employeeTO);
			}
			}
			request.setAttribute("employees", employeeBO.getAllEmp());
			RequestDispatcher view = request.getRequestDispatcher(viewEmp);

			view.forward(request, response);
			LOG.info("Exit - method doPost in UserController class");
		} catch (ParseException parseException) {
			request.setAttribute("message", Constants.EXCEPTION);
			LOG.info("UserController class - ParseException"+parseException.getMessage());
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);// forwards the request to
			// error.jsp in case of login failure or any exception
		} catch (DatabaseOperationException dbException) {
			LOG.info("UserController class - DatabaseOperationException"+dbException.getMessage());
			request.setAttribute("message",Constants.EXCEPTION);
			// as attribute to the request
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);// forwards the request to
			// error.jsp in case of login failure or any exception
		} catch (ApplicationException appException) {
			// TODO Auto-generated catch block
			LOG.info("UserController class - ApplicationException"+appException.getMessage());
			request.setAttribute("message", Constants.EXCEPTION);
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);
		} catch (BusinessException busException) {
			LOG.info("UserController class - BusinessException"+busException.getMessage());
			request.setAttribute("message", busException.getMessage());
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.USERPAGE);
			dispatcher.forward(request, response);
		}
		catch (Exception exception) {
			LOG.info("UserController class - Exception"+exception.getMessage());
			request.setAttribute("message", Constants.EXCEPTION);
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);
		}
		
	}
}
