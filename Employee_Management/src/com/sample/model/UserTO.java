package com.sample.model;

// TODO: Auto-generated Javadoc
/**
 * The Class UserTO.
 *
 * @author t-Renjith Used for storing the user details
 */
/**
 * @author t-Renjith
 * 
 */
public class UserTO {

	/** username-Holds the username of the user password-holds the password of the user. */
	private String userid;
	
	/** The password. */
	private String password;	
	
	/** The role. */
	private String role;	

	private int result;
	

	
	/**
	 * Gets the userid.
	 *
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}


	/**
	 * Sets the userid.
	 *
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}


	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}


	/**
	 * Sets the role.
	 *
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}


	/**
	 * The getter method which returns the password.
	 *
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * The setter method which sets value to the password variable.
	 *
	 * @param password -This is the password value to be set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}


	/**
	 * @return the result
	 */
	public int getResult() {
		return result;
	}


	/**
	 * @param result the result to set
	 */
	public void setResult(int result) {
		this.result = result;
	}


	

}
