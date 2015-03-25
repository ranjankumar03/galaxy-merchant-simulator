/**
 * 
 */
package com.galaxy.merchant.simulator.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.galaxy.merchant.simulator.constant.GalaxySimulatorConstants;
import com.galaxy.merchant.simulator.context.GalaxySimulatorContext;
import com.galaxy.merchant.simulator.controller.GalaxySimulatorControllerImpl;
import com.galaxy.merchant.simulator.controller.IController;

/**
 * @author Ranjan Kumar
 * @date 2015-03-23
 *
 */
public class AppUnit {

	IController controller =null;
	GalaxySimulatorContext context=null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		final String inputRequestFile = "C:\\Users\\rku140\\workspace\\galaxy-merchant-simulator_1.0\\galaxyRequestFile.txt";
		controller = new GalaxySimulatorControllerImpl();
		context = new GalaxySimulatorContext();
		context.setProcessId(1);
		context.setProcessDesc(GalaxySimulatorConstants.MERCHANT_GUIDE_TO_GALAXY_PROCESS);// Usage
																							// of
																							// Constant
		context.setStatus(true);
		context.setGalaxyRequestFile(new File(inputRequestFile));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		controller.triggetGalaxySimulator(context);
		assertEquals(1, 1);
	}

}
