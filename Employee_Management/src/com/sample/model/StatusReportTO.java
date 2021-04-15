package com.sample.model;


	import java.io.Serializable;
import java.util.Date;


	// TODO: Auto-generated Javadoc
/**
	 * The Class EmployeeTO.
	 */
	public class StatusReportTO implements Serializable {

	    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
		private int statusId;
	    
    	/** rl type. */
    	private String comments;
	    
    	/** details. */
    	private String details;
	    
    	/** The details. */
    	private Date createDate;
	    
    	private String userId;
    	private int complianceId;
  
    	 
 	    /** The department. */
 	    private DepartmentTO department;



		/**
		 * @return the statusId
		 */
		public int getStatusId() {
			return statusId;
		}



		/**
		 * @param statusId the statusId to set
		 */
		public void setStatusId(int statusId) {
			this.statusId = statusId;
		}



		/**
		 * @return the comments
		 */
		public String getComments() {
			return comments;
		}



		/**
		 * @param comments the comments to set
		 */
		public void setComments(String comments) {
			this.comments = comments;
		}



		/**
		 * @return the details
		 */
		public String getDetails() {
			return details;
		}



		/**
		 * @param details the details to set
		 */
		public void setDetails(String details) {
			this.details = details;
		}



		/**
		 * @return the createDate
		 */
		public Date getCreateDate() {
			return createDate;
		}



		/**
		 * @param createDate the createDate to set
		 */
		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}



		/**
		 * @return the department
		 */
		public DepartmentTO getDepartment() {
			return department;
		}



		/**
		 * @param department the department to set
		 */
		public void setDepartment(DepartmentTO department) {
			this.department = department;
		}



		/**
		 * @return the userId
		 */
		public String getUserId() {
			return userId;
		}



		/**
		 * @param userId the userId to set
		 */
		public void setUserId(String userId) {
			this.userId = userId;
		}

		/**
		 * @return the complianceId
		 */
		public int getComplianceId() {
			return complianceId;
		}


		/**
		 * @param complianceId the complianceId to set
		 */
		public void setComplianceId(int complianceId) {
			this.complianceId = complianceId;
		}



		public void setDepartment(String string) {
			// TODO Auto-generated method stub
			
		}
	
}
