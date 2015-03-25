/**
 * 
 */
package com.galaxy.merchant.simulator.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Ranjan Kumar
 * @date 2015-03-23
 *
 */
public interface IReader {
	
	public List<String> read(File reader) throws IOException;

}
