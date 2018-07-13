package com.mailchimp.automation.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mailchimp.automation.model.LeadersInfo;

public class CSVFileHandler {

	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	private static final int LEADERS_NAME_IDX = 0;
	private static final int LEADERS_DESIGNATION_IDX = 1;
	private static final int LEADERS_DESCRIPTION_IDX = 2;
	
	//CSV file header
	private static final String FILE_HEADER = "Name,Designation,Description";
	
	private static void makeDataDir() {
		File f = new File(AppConstant.CSV_FILE_PATH);
		try {
			if (f.exists() == false) {
				f.mkdir();
				System.out.println("Directory Created");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeCsvFile(List<LeadersInfo> leadersInfoList) {

		makeDataDir();
		
	    FileWriter fileWriter = null;
	    try {
	        fileWriter = new FileWriter(AppConstant.CSV_FILE_PATH + "LeadershipInfo.csv");
	        //Write the CSV file header
	        fileWriter.append(FILE_HEADER.toString());
	        //Add a new line separator after the header
	        fileWriter.append(NEW_LINE_SEPARATOR);


	        //Write a new student object list to the CSV file
	        for (LeadersInfo info : leadersInfoList) {

	            fileWriter.append(info.getName());
	            fileWriter.append(COMMA_DELIMITER);
	            
	            fileWriter.append(info.getDesignation());
	            fileWriter.append(COMMA_DELIMITER);

	            String description = '"' + info.getDescription() + '"';
	            
	            fileWriter.append(description);
	            fileWriter.append(COMMA_DELIMITER);

	            fileWriter.append(NEW_LINE_SEPARATOR);
	        }

	        System.out.println("CSV file was created successfully !!!");

	    } catch (Exception e) {

	        System.out.println("Error in CsvFileWriter !!!");
	        e.printStackTrace();
	    } 
	    finally {
	        try {
	            fileWriter.flush();
	            fileWriter.close();
	        } 
	        catch (IOException e) {
	            System.out.println("Error while flushing/closing fileWriter !!!");
	            e.printStackTrace();
	        }
	    }

	}
	
	public static List<LeadersInfo> readCsvFile() {

		//Create a new list of leaders to be filled by CSV file data
        List<LeadersInfo> leadersList = new ArrayList();
	    BufferedReader fileReader = null;

	    try {
	        String line = "";
	        
	        //Create the file reader
	        fileReader = new BufferedReader(new FileReader(AppConstant.CSV_FILE_PATH));

	        //Read the CSV file header to skip it
	        fileReader.readLine();

	        //Read the file line by line starting from the second line
	        while ((line = fileReader.readLine()) != null) {

	            //Get all tokens available in line
	            String[] tokens = line.split(COMMA_DELIMITER);

	            if (tokens.length > 0) {
	                //Create a new student object and fill his  data
	            	LeadersInfo leaders = new LeadersInfo(tokens[LEADERS_NAME_IDX], tokens[LEADERS_NAME_IDX], tokens[LEADERS_NAME_IDX]);
	            	leadersList.add(leaders);
	            }
	        }

	        //Print the new student list
	        for (LeadersInfo leaders : leadersList) {
	            System.out.println(leaders.toString());
	        }

	    }catch (Exception e) {
	        System.out.println("Error in CsvFileReader !!!");
	        e.printStackTrace();
	    } finally {

	        try {
	            fileReader.close();
	        } catch (IOException e) {
	            System.out.println("Error while closing fileReader !!!");
	            e.printStackTrace();
	        }
	    }

	    return leadersList;
	}
}
