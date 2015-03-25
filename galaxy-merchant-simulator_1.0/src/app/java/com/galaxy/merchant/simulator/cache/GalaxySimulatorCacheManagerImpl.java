package com.galaxy.merchant.simulator.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.log4j.Logger;

public class GalaxySimulatorCacheManagerImpl implements ICache{

	private static final Logger log = Logger.getLogger(GalaxySimulatorCacheManagerImpl.class);
	
	private Map<String,String> transMap = null;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GalaxySimulatorCacheManagerImpl(){
		transMap = new LinkedHashMap();
	}
	@Override
	public Map<String, String> loadTransMap(String line) {
		// TODO Auto-generated method stub
		transMap.put(line.substring(0, 4), line.substring(8));
		return transMap;
	}

}
