/**
 * 
 */
package com.galaxy.merchant.simulator.test;

import java.io.File;

import org.apache.log4j.Logger;

import com.galaxy.merchant.simulator.client.Client;
import com.galaxy.merchant.simulator.constant.GalaxySimulatorConstants;
import com.galaxy.merchant.simulator.context.GalaxySimulatorContext;
import com.galaxy.merchant.simulator.controller.GalaxySimulatorControllerImpl;
import com.galaxy.merchant.simulator.controller.IController;
import com.galaxy.merchant.simulator.exception.PerformGalaxySimulatorException;

/**
 * @author Ranjan Kumar
 * @date 2015-03-23
 *
 */
public class Test {

	private static final Logger log = Logger.getLogger(Client.class);

	/**
	 * @Test Case I
	 */
	private static String inputRequestFile = "C:\\Users\\rku140\\workspace\\galaxy-merchant-simulator_1.0\\testsrc\\app\\java\\galaxyRequestFile_testcase_01.txt";
	
	/**
	 * @Test Case II
	 */
	//private static String inputRequestFile = "C:\\Users\\rku140\\workspace\\galaxy-merchant-simulator_1.0\\testsrc\\app\\java\\galaxyRequestFile_testcase_02.txt";
	
	/**
	 * @Test Case III
	 */
	//private static String inputRequestFile = "C:\\Users\\rku140\\workspace\\galaxy-merchant-simulator_1.0\\testsrc\\app\\java\\galaxyRequestFile_testcase_03.txt";
	
	/**
	 * @Test Case IV
	 */
	//private static String inputRequestFile = "C:\\Users\\rku140\\workspace\\galaxy-merchant-simulator_1.0\\testsrc\\app\\java\\galaxyRequestFile_testcase_04.txt";
	
	
	static IController controller = null;
	static GalaxySimulatorContext context = null;

	/**
	 * @param args
	 * @throws PerformGalaxySimulatorException
	 */
	public static void main(String[] args)
			throws PerformGalaxySimulatorException {
		// TODO Auto-generated method stub

		context = new GalaxySimulatorContext();
		context.setProcessId(1);
		context.setProcessDesc(GalaxySimulatorConstants.MERCHANT_GUIDE_TO_GALAXY_PROCESS);// Usage
																							// of
																							// Constant
		context.setStatus(true);
		context.setGalaxyRequestFile(new File(inputRequestFile));

		try {
			controller = new GalaxySimulatorControllerImpl();
			log.info("Calling Controller........");
			controller.triggetGalaxySimulator(context);
		} catch (Exception e) {
			// TODO: handle exception
			throw new PerformGalaxySimulatorException(
					"Process encountered excepion.............." + e);
		} finally {
			log.info("Client program exiting.................");
			System.out
					.println("==============================<<Client Terminating>>===================================");
			System.exit(0);
		}

	}


}
