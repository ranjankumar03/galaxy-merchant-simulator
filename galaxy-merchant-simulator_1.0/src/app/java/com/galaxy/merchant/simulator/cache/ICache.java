/**
 * 
 */
package com.galaxy.merchant.simulator.cache;

import java.util.Map;

/**
 * @author Ranjan Kumar
 * @date 2015-03-23
 * TransMap refres to load mappings wrt to glob=I,prok=V etc
 *
 */
public interface ICache {
	
	public Map<String,String> loadTransMap(String line);
}
