/**
 * 
 */
package com.galaxy.merchant.simulator.context;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * @author Ranjan Kumar
 * @date 2015-03-23
 *
 */
public class GalaxySimulatorContext extends Context {

	private static final Logger log = Logger
			.getLogger(GalaxySimulatorContext.class);

	private File galaxyRequestFile;

	public File getGalaxyRequestFile() {
		return galaxyRequestFile;
	}

	public void setGalaxyRequestFile(File galaxyRequestFile) {
		this.galaxyRequestFile = galaxyRequestFile;
	}

}
