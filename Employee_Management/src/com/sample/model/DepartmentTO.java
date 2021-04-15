package com.sample.model;


	import java.io.Serializable;

	// TODO: Auto-generated Javadoc
/**
	 * The Class EmployeeTO.
	 */
	public class DepartmentTO implements Serializable{

	    /** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

		/** The userid. */
    	private int departId;
	    
    	/** The first name. */
    	private String departName;
	    
    	
    	/**
	     * Gets the depart id.
	     *
	     * @return the depart id
	     */
	    public int getDepartId() {
			return departId;
		}


		/**
		 * Sets the depart id.
		 *
		 * @param departId the new depart id
		 */
		public void setDepartId(int departId) {
			this.departId = departId;
		}


		/**
		 * Gets the depart name.
		 *
		 * @return the depart name
		 */
		public String getDepartName() {
			return departName;
		}


		/**
		 * Sets the depart name.
		 *
		 * @param departName the new depart name
		 */
		public void setDepartName(String departName) {
			this.departName = departName;
		}


	
}
