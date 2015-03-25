/**
 * 
 */
package com.galaxy.merchant.simulator.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.galaxy.merchant.simulator.context.GalaxySimulatorContext;
import com.galaxy.merchant.simulator.executor.GalaxySimulatorCalcAlgorithm;
import com.galaxy.merchant.simulator.executor.IGalaxySimulatorCalcAlgorithm;
import com.galaxy.merchant.simulator.util.FileReader;
import com.galaxy.merchant.simulator.util.IReader;
import com.galaxy.merchant.simulator.util.InputWriter;

/**
 * @author Ranjan Kumar
 * @date 2015-03-23
 *
 */
public class GalaxySimulatorControllerImpl implements IController {

	private static final Logger log = Logger
			.getLogger(GalaxySimulatorControllerImpl.class);
	IReader reader = null;
	InputWriter writer = null;
	IGalaxySimulatorCalcAlgorithm exector = null;
	List<String> inputList = null;
	
	public GalaxySimulatorControllerImpl(){
		reader = new FileReader();
		writer = new InputWriter();
		exector = new GalaxySimulatorCalcAlgorithm();
	}

	public void triggetGalaxySimulator(GalaxySimulatorContext context) {

		// Read Input File into List
		log.info("Inside Controller...");
		try {
			inputList = reader.read(context.getGalaxyRequestFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Write/Print on Console
		System.out
				.println("================================<<Input Begins>>=======================================");
		writer.writeOnConsole(inputList);
		System.out
				.println("=================================<<Input Ends>>========================================");

		// call executor
		exector.execute(inputList);

	}

}