package com.sample.model;


	import java.io.Serializable;
import java.util.Date;


	// TODO: Auto-generated Javadoc
/**
	 * The Class EmployeeTO.
	 */
	public class EmployeeTO implements Serializable {

	    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

		/** The userid. */
    	private int userid;
	    
    	/** The first name. */
    	private String firstName;
	    
    	/** The last name. */
    	private String lastName;
	    
    	/** The dob. */
    	private Date dob;
	    
    	/** The email. */
    	private String email;
    	 
 	    /** The department. */
 	    private DepartmentTO department;
	    
    	/**
    	 * Gets the userid.
    	 *
    	 * @return the userid
    	 */
    	public int getUserid() {
	        return userid;
	    }
	    
    	/**
    	 * Sets the userid.
    	 *
    	 * @param userid the new userid
    	 */
    	public void setUserid(int userid) {
	        this.userid = userid;
	    }
	    
    	/**
    	 * Gets the first name.
    	 *
    	 * @return the first name
    	 */
    	public String getFirstName() {
	        return firstName;
	    }
	    
    	/**
    	 * Sets the first name.
    	 *
    	 * @param firstName the new first name
    	 */
    	public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    
    	/**
    	 * Gets the last name.
    	 *
    	 * @return the last name
    	 */
    	public String getLastName() {
	        return lastName;
	    }
	    
    	/**
    	 * Sets the last name.
    	 *
    	 * @param lastName the new last name
    	 */
    	public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    
    	/**
    	 * Gets the dob.
    	 *
    	 * @return the dob
    	 */
    	public Date getDob() {
	        return dob;
	    }
	    
    	/**
    	 * Sets the dob.
    	 *
    	 * @param dob the new dob
    	 */
    	public void setDob(Date dob) {
	        this.dob = dob;
	    }
	    
    	/**
    	 * Gets the email.
    	 *
    	 * @return the email
    	 */
    	public String getEmail() {
	        return email;
	    }
	    
    	/**
    	 * Sets the email.
    	 *
    	 * @param email the new email
    	 */
    	public void setEmail(String email) {
	        this.email = email;
	    }
	    
    	/**
	     * Gets the department.
	     *
	     * @return the department
	     */
	    public DepartmentTO getDepartment() {
			return department;
		}

		/**
		 * Sets the department.
		 *
		 * @param department the new department
		 */
		public void setDepartment(DepartmentTO department) {
			this.department = department;
		}
  
	
}
