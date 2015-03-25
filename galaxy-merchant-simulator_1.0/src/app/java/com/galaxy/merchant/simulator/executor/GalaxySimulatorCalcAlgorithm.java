/**
 * 
 */
package com.galaxy.merchant.simulator.executor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.galaxy.merchant.simulator.cache.GalaxySimulatorCacheManagerImpl;
import com.galaxy.merchant.simulator.cache.ICache;
import com.galaxy.merchant.simulator.constant.GalaxySimulatorConstants;
import com.galaxy.merchant.simulator.util.InputLineType;
import com.galaxy.merchant.simulator.util.RomanValEnum;

/**
 * @author Ranjan Kumar
 * @date 2015-03-23
 *
 */
public class GalaxySimulatorCalcAlgorithm implements IGalaxySimulatorCalcAlgorithm {

	private static final Logger log = Logger
			.getLogger(GalaxySimulatorCalcAlgorithm.class);
	
	InputLineType inputType = null;
	ICache cache = null;
	private static Map<String, String> transMap = null;
	private static Map<String, Double> currencyValueMap = null;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GalaxySimulatorCalcAlgorithm() {
		inputType = new InputLineType();
		cache = new GalaxySimulatorCacheManagerImpl();
		transMap = new HashMap();
		currencyValueMap = new HashMap();
	}

	@Override
	public void execute(List<String> inputList) {
		log.info("Inside Executor...");
		String currency = "";

		for (String line : inputList) {
			String lineType = inputType.getInputLineType(line);
			if (lineType
					.equalsIgnoreCase(GalaxySimulatorConstants.ASSIGNMENT_TYPE)) {
				transMap = cache.loadTransMap(line);
			} else if (lineType
					.equalsIgnoreCase(GalaxySimulatorConstants.CREDITS_TYPE)) {

				//glob glob Silver is 34 Credits
				String[] trans = line.split(" ");
				// glob glob cut
				String[] preCurrCollection = { trans[0], trans[1] };
				double preCurrValue = calcPreCurrValue(preCurrCollection);
				String curr = trans[2];
				// System.out.println("Currency->"+ curr);
				int credits = Integer.parseInt(trans[4]);
				// System.out.println("Credits->"+credits);
				double value = credits / preCurrValue;
				currencyValueMap.put(curr, value);

			} else if (lineType
					.equalsIgnoreCase(GalaxySimulatorConstants.HOWMANY_TYPE)) {
				String[] fullStringArray = line.split(" ");
				int index = -1;
				for (int i = 0; i < fullStringArray.length; i++) {
					if (fullStringArray[i]
							.equalsIgnoreCase(GalaxySimulatorConstants.PROK)
							|| fullStringArray[i]
									.equalsIgnoreCase(GalaxySimulatorConstants.GLOB)
							|| fullStringArray[i]
									.equalsIgnoreCase(GalaxySimulatorConstants.TEGJ)
							|| fullStringArray[i]
									.equalsIgnoreCase(GalaxySimulatorConstants.PISH)) {
						index = i;
						break;
					}
				}
				// get currency value
				double value = 0;
				String curr = fullStringArray[fullStringArray.length - 2];
				for (String k : currencyValueMap.keySet()) {
					if (k.equals(curr)) {
						value = currencyValueMap.get(k);
					}
				}

				String[] reduceStringArray = new String[fullStringArray.length
						- index - 2];

				String prefix = "";
				for (int i = index, j = 0; i < fullStringArray.length - 2; i++, j++) {
					reduceStringArray[j] = fullStringArray[i];
					prefix += reduceStringArray[j] + " ";
				}

				// System.out.println("Prefix::"+prefix);
				double transValue = calcPreCurrValue(reduceStringArray);
				double total = transValue * value;
				if (total != 0) {
					System.out.println(prefix + "" + curr + " " + "is "
							+ (long) total + " " + currency + "" + "Credits");
				}

			} else if (lineType
					.equalsIgnoreCase(GalaxySimulatorConstants.HOWMUCH_TYPE)) {
				Pattern ptn = Pattern
						.compile(GalaxySimulatorConstants.RGX_HOW_MUCH);
				Matcher mcher = ptn.matcher(line);
				mcher.matches();

				String[] trans = mcher.group(1).split(" ");
				double transValue = calcPreCurrValue(trans);
				if (transValue != 0) {
					System.out.println(mcher.group(1) + "is " + transValue);
				}
			} else {
				System.out.println("I have no idea what you are talking about");

			}

		}

	}

	private double calcPreCurrValue(String[] trans) {
		double value = 0.0;
		List<String> romans = new ArrayList<String>();
		for (int i = 0; i < trans.length; i++) {
			if (!transMap.keySet().contains(trans[i])) {
				System.out
						.println(GalaxySimulatorConstants.INVALID_INPUT_FORMAT_MSG);
				return 0;
			}
			romans.add(transMap.get(trans[i]));
		}
		List<Integer> src = new ArrayList<Integer>();
		for (String s : romans) {
			src.add(fetchValueByRoman(s));
		}

		List<Integer> newSrc = perfromSubstractLogic(src);
		;
		for (int i : newSrc) {
			value += i;
		}

		return value;

	}

	private List<Integer> perfromSubstractLogic(List<Integer> numbers) {
		int currentElement;

		for (int i = 0; i < numbers.size() - 1; i++) {
			currentElement = numbers.get(i);
			if (currentElement < numbers.get(i + 1)) {
				numbers.set(i, -currentElement);
			}
		}
		return numbers;

	}

	private Integer fetchValueByRoman(String roman) {
		switch (roman) {
		case "I":
			return RomanValEnum.I.getValue();
		case "V":
			return RomanValEnum.V.getValue();
		case "X":
			return RomanValEnum.X.getValue();
		case "L":
			return RomanValEnum.L.getValue();
		case "C":
			return RomanValEnum.C.getValue();
		case "D":
			return RomanValEnum.D.getValue();
		case "M":
			return RomanValEnum.M.getValue();
		default:
			return 0;
		}

	}
}
