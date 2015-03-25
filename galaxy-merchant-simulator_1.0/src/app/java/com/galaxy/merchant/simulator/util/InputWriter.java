/**
 * 
 */
package com.galaxy.merchant.simulator.util;

import java.util.List;

/**
 * @author Ranjan Kumar
 * @date 2015-03-23
 *
 */
public class InputWriter {
	
	public void writeOnConsole(List<String> inputList){
		
		for(String line : inputList){
			System.out.println(line);
		}
		
	}

}
