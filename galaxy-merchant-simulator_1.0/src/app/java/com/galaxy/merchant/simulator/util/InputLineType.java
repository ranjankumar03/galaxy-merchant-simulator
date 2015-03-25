/**
 * 
 */
package com.galaxy.merchant.simulator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.galaxy.merchant.simulator.constant.GalaxySimulatorConstants;

/**
 * @author Ranjan Kumar
 * @date 2015-03-23
 *
 */
public class InputLineType {

	private static String rgxAssignment = "^(glob|prok|pish|tegj){1}.* is{1} (I|V|X|L){1}$";
	private static String rgxCredits = "((?:[a-z]+ )+)([A-Z]\\w+) is (\\d+) ([A-Z]\\w+)$";
	private static String rgxHowMany = "^((how many Credits is)?) ((pish|tegj|glob|prok)\\s?){0,}((Silver|Gold|Iron)\\s?){1}\\?$";
	private static String rgxHowMuch = "^how much is ((?:\\w+[^0-9] )+)\\?$";

	private static String[] rgxArray = new String[] { rgxAssignment,
			rgxCredits, rgxHowMany, rgxHowMuch };

	public String getInputLineType(String line) {

		String inputType = GalaxySimulatorConstants.INITIAL_INPUT_TYPE;
		for (int i = 0; i < rgxArray.length; i++) {
			Pattern ptn = Pattern.compile(rgxArray[i]);
			Matcher mcher = ptn.matcher(line);
			boolean bool = mcher.matches();

			if (bool) {
				switch (i) {
				case 0:
					inputType = GalaxySimulatorConstants.ASSIGNMENT_TYPE;
					// System.out.println("assignment case::");
					break;
				case 1:
					inputType = GalaxySimulatorConstants.CREDITS_TYPE;
					// System.out.println("credit case::");
					break;
				case 2:
					inputType = GalaxySimulatorConstants.HOWMANY_TYPE;
					// System.out.println("how many case::");
					break;
				case 3:
					inputType = GalaxySimulatorConstants.HOWMUCH_TYPE;
					// System.out.println("how much");
					break;
				default:
					break;
				}
			}

		}

		return inputType;

	}

}
