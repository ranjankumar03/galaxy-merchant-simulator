package com.galaxy.merchant.simulator.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class FileReader implements IReader {
	private static final Logger log = Logger.getLogger(FileReader.class);

	String line = null;
	List<String> inputList = null;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FileReader() {
		inputList = new ArrayList();
	}

	@Override
	public List<String> read(File reader) throws IOException {

		log.info("Inside Reader...........");
		try {
			BufferedReader br = new BufferedReader(new java.io.FileReader(
					reader));

			while ((line = br.readLine()) != null) {
				inputList.add(line.trim());

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputList;
	}

}
