package com.sample.model;


	import java.io.Serializable;
import java.util.Date;


	// TODO: Auto-generated Javadoc
/**
	 * The Class EmployeeTO.
	 */
	public class ComplianceTO implements Serializable {

	    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
		private int complainceId;
	    
    	/** rl type. */
    	private String rlType;
	    
    	/** details. */
    	private String details;
	    
    	/** The details. */
    	private Date createDate;
	    
  
    	 
 	    /** The department. */
 	    private DepartmentTO department;
		
		/** The emp count. */
		private int empCount;
		
		/** The sts count. */
		private int stsCount;
		private String status;
		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}

		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}

		/**
		 * @return the rlType
		 */
		public String getRlType() {
			return rlType;
		}

		/**
		 * @param rlType the rlType to set
		 */
		public void setRlType(String rlType) {
			this.rlType = rlType;
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

		public int getComplainceId() {
			return complainceId;
		}

		public void setComplainceId(int complainceId) {
			this.complainceId = complainceId;
		}

		/**
		 * @return the empCount
		 */
		public int getEmpCount() {
			return empCount;
		}

		/**
		 * @param empCount the empCount to set
		 */
		public void setEmpCount(int empCount) {
			this.empCount = empCount;
		}

		/**
		 * @return the stsCount
		 */
		public int getStsCount() {
			return stsCount;
		}

		/**
		 * @param stsCount the stsCount to set
		 */
		public void setStsCount(int stsCount) {
			this.stsCount = stsCount;
		}

		public void setDepartment(String string) {
			// TODO Auto-generated method stub
			
		}
	
}
