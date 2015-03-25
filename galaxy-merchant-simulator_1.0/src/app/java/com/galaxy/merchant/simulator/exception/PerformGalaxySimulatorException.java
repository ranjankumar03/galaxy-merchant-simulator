/**
 * 
 */
package com.galaxy.merchant.simulator.exception;

/**
 * @author Ranjan Kumar
 * @date 2015-03-23
 *
 */
public class PerformGalaxySimulatorException extends KernelException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Object objectInIssue;

	public PerformGalaxySimulatorException() {
		// TODO Auto-generated constructor stub
		super();
	}

	public PerformGalaxySimulatorException(String argMessage) {
		super(argMessage);
	}

	public PerformGalaxySimulatorException(String argMessage, Object objectInIssue) {
		super(argMessage);
		this.objectInIssue = objectInIssue;
	}

	@Override
	public String toString() {
		return "PerfromException [objectInIssue=" + objectInIssue + "]";
	}


}
