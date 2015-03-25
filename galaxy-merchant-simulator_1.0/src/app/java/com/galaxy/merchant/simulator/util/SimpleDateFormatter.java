/**
 * 
 */
package com.galaxy.merchant.simulator.util;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @author Ranjan Kumar
 * @date 2015-03-23
 *
 */
public class SimpleDateFormatter {

	private static final Logger log=Logger.getLogger(SimpleDateFormatter.class);

	Date date = null;

	public static Calendar StrintoDate(String time) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR, Integer.parseInt(time.split(":")[0]));
		calendar.set(Calendar.MINUTE, Integer.parseInt(time.split(":")[1]));
		return calendar;
	}
}
