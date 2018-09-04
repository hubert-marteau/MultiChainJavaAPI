/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

/**
 * @author Ub - H. MARTEAU
 * @version 4.13
 */
public class MultichainException extends Exception {

	private String object;
	private String reason;

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 2412952380749244614L;

	public MultichainException(String excep_object, String excep_reason) {
		object = excep_object;
		reason = excep_reason;
	}
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MultichainException [\r\n" + "                      object=" + object + ",\r\n"
				+ "                      reason=" + reason + ",\r\n" + "                      message=" + super.getMessage()
				+ ",\r\n" + "                      cause=" + getCause() + "\r\n]";
	}

	public String toShortString() {
		return "MultichainException [\r\n" + "                      object=" + object + ",\r\n"
				+ "                      reason=" + reason + "\r\n]";
	}

	/**
	 * @return the object
	 */
	public String getObject() {
		return object;
	}

	/**
	 * @param object
	 *            the object to set
	 */
	public void setObject(String object) {
		this.object = object;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason
	 *            the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}



	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return toString();
	}

}
