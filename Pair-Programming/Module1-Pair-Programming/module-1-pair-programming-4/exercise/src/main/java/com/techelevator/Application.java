package com.techelevator;


import com.techelevator.search.SearchDomain;
import com.techelevator.search.SearchEngine;
import com.techelevator.util.TELog;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		try {

			// Step Two: Create TELog, and log the start of the application.
			//
			TELog.log("Search application started");
			
			
			// Step Four: Instantiate a Search Domain
			//
			SearchDomain data = new SearchDomain("data");
			System.out.println(data);
			TELog.log(data.toString());

			// Step Six: Single word search
			//
			SearchEngine singleWordSearch = new SearchEngine(data);
			singleWordSearch.indexFiles();
			List<String> foundInFiles = singleWordSearch.search("squirrel");
			if (foundInFiles.size()>0) {
				for (String file : foundInFiles) {
					System.out.println(file);
				}
			} else {
				System.out.println("Search does not appear in the indexed files.");
			}
			
			// Step Seven: Multiple word search
			//
			SearchEngine multiWordSearch = new SearchEngine(data);
			multiWordSearch.indexFiles();
			List<String> foundFile = multiWordSearch.search("telephone line");
			if (foundFile.size()>0) {
				for (String found :foundFile) {
					System.out.println(found);
				}
			} else {
				System.out.println("Search does not appear in the indexed files.");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
