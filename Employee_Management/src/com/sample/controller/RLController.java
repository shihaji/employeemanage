package com.sample.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.sample.bo.ComplianceBO;
import com.sample.bo.DepartmentBO;
import com.sample.constants.Constants;
import com.sample.constants.ErrorConstants;
import com.sample.exceptions.ApplicationException;
import com.sample.exceptions.BusinessException;
import com.sample.exceptions.DatabaseOperationException;
import com.sample.model.ComplianceTO;
import com.sample.model.DepartmentTO;
import com.sample.model.StatusReportTO;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
public class RLController extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The view RL. */
	private static String viewRL = "/createRL.jsp";
	/** The view RL. */
	private static String viewRLUser = "/listUser.jsp";
	/** The view RL. */
	private static String statusreport = "/statusReport.jsp";

	/** The employee service. */
	private ComplianceBO complianceBO = new ComplianceBO();
	
	/** The department bo. */
	private DepartmentBO departmentBO = new DepartmentBO();
	/**
	 * Instantiates a new user controller.
	 */
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger("RLController");
	public RLController() {
		super();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOG.info("Inside - method doGet in RLController class");
		 HttpSession session = request.getSession(true);
		 List<ComplianceTO> complianceList = new ArrayList<ComplianceTO>();
		 RequestDispatcher view=null;
		 int complainceID = 0;
		try {
			final String action = request.getParameter("action");
				List<DepartmentTO> departlist = departmentBO.getAllDepart();
				request.setAttribute("departments", departlist);
			String userId = (String)session.getAttribute("UserID");
			String role = (String)session.getAttribute("Role");
			if(role!=null && role.trim().equals("ADMIN")){
			complianceList	= complianceBO.getAllRL();
			view = request.getRequestDispatcher(viewRL);
			}
			else if(action!=null && action.trim().equals("createStatusRpt")){
				complainceID = Integer.parseInt(request.getParameter("compId"));
				session.setAttribute("ComplianceID", complainceID);
				request.setAttribute("reports", complianceBO.getAllStatusReport(userId,complainceID));
				
				view = request.getRequestDispatcher(statusreport);
			 }
			else{
				complianceList	= complianceBO.getAllRL(userId);
				view = request.getRequestDispatcher(viewRLUser);
			}
			request.setAttribute("records", complianceList);
			LOG.info("Exit- method doGet in RLController class");
			view.forward(request, response);
		} catch (DatabaseOperationException dbException) {
			LOG.info("RLController class - Exception"+dbException.getMessage());
			request.setAttribute("message",Constants.EXCEPTION);
			// as attribute to the request
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);// forwards the request to
			// error.jsp in case of login failure or any exception
		} catch (ApplicationException appException) {
			LOG.info("RLController class - Exception"+appException.getMessage());
			// TODO Auto-generated catch block
			request.setAttribute("message", Constants.EXCEPTION);
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);
		}
		catch (Exception exception) {
			LOG.info("RLController class - Exception"+exception.getMessage());
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
		LOG.info("Inside - method doPost in RLController class");
		List<ComplianceTO> complianceList = new ArrayList<ComplianceTO>();
		String userId=null;
		RequestDispatcher view =null;
		try {
			final String action = request.getParameter("action");
			 HttpSession session = request.getSession(true);
			 userId = (String)session.getAttribute("UserID");
			String role = (String)session.getAttribute("Role");
			if(action==null && role.trim().equals("ADMIN")){
			ComplianceTO complainceTO = new ComplianceTO();
		
			DepartmentTO departmentTO = new DepartmentTO();
			complainceTO.setRlType(request.getParameter("rlType"));
			complainceTO.setDetails(request.getParameter("details"));
			Date createDt = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("createDate"));
			complainceTO.setCreateDate(createDt);
			departmentTO.setDepartId(Integer.parseInt(request.getParameter("deptId")));
			departmentTO.setDepartName(request.getParameter("deptNm"));
			complainceTO.setDepartment(departmentTO);
				complianceBO.createRL(complainceTO);
				request.setAttribute("records", complianceBO.getAllRL());
	
			}
			else if(action!=null && action.trim().equals("statusrpt")){
				StatusReportTO statusreport = new StatusReportTO();
				int compId = (Integer) session.getAttribute("ComplianceID");
				statusreport.setComplianceId(compId);
				statusreport.setComments(request.getParameter("comments"));
				Date createDt = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("createDate"));
				statusreport.setCreateDate(createDt);
				statusreport.setUserId(userId);
				complianceBO.createStatusReport(statusreport);
				request.setAttribute("reports", complianceBO.getAllStatusReport(userId,compId));
				request.setAttribute("complianceList", complianceBO.getAllRL(userId));
				session.removeAttribute("ComplianceID");
			}
			else{
				complianceList	= complianceBO.getAllRL(userId);
				List<DepartmentTO> departlist = departmentBO.getAllDepart();
				request.setAttribute("departments", departlist);
				request.setAttribute("complianceList", complianceList);
				request.setAttribute("records", complianceBO.getAllRL());
			}
			
			if(role!=null && role.trim().equals("ADMIN")){
			 view = request.getRequestDispatcher(viewRL);
			}
			else if(action!=null && action.trim().equals("statusrpt")){
				view = request.getRequestDispatcher(viewRLUser);
			}
			else{
				 view = request.getRequestDispatcher(viewRLUser);
			}
			LOG.info("Exit - method doPost in RLController class");
			view.forward(request, response);
		} catch (ParseException parseException) {
			LOG.info("RLController class - Exception"+parseException.getMessage());
			request.setAttribute("message", Constants.EXCEPTION);
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);// forwards the request to
			// error.jsp in case of login failure or any exception
		} catch (DatabaseOperationException dbException) {
			LOG.info("RLController class - Exception"+dbException.getMessage());
			request.setAttribute("message",Constants.EXCEPTION);
			// as attribute to the request
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);// forwards the request to
			// error.jsp in case of login failure or any exception
		} catch (ApplicationException appException) {
			// TODO Auto-generated catch block
			LOG.info("RLController class - Exception"+appException.getMessage());
			request.setAttribute("message", Constants.EXCEPTION);
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);
		} catch (BusinessException busException) {
			LOG.info("RLController class - Exception"+busException.getMessage());
			request.setAttribute("message", Constants.EXCEPTION);
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.USERPAGE);
			dispatcher.forward(request, response);
		}
		catch (Exception exception) {
			LOG.info("RLController class - Exception"+exception.getMessage());
			request.setAttribute("message", Constants.EXCEPTION);
			final RequestDispatcher dispatcher = request
					.getRequestDispatcher(ErrorConstants.ERRORPAGE);
			dispatcher.forward(request, response);
		}
		
	}
}
