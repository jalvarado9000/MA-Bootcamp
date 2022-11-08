package com.techelevator.search;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * The Search Domain is a list of files to be read and indexed by the Search Engine.
 * 
 * Folders are NOT recursively searched. 
 */
public class SearchDomain {

	private String folder;
	private List<String> files;
	
	/**
	 * Create a Search Domain of a folder
	 * 
	 * @param folder
	 * @throws SearchDomainException
	 */
	public SearchDomain(String folder) throws SearchDomainException {
		this.folder = folder;
		this.files = buildDomain();
	}
	
	public String getFolder() {
		return folder;
	}

	public List<String> getFiles() {
		return files;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (String file : files) {
			sb.append(file);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * Folders are NOT recursively searched.
	 * 
	 * @return
	 * @throws SearchDomainException
	 */
	private List<String> buildDomain() throws SearchDomainException {
		List<String> files = new ArrayList<>();
		// Step Three: Complete the buildDomain method

		File dataFolderLocation = new File("exercise\\" +folder);
		if (dataFolderLocation.isDirectory()) {
			for (File file: dataFolderLocation.listFiles()) {
				if(file.isFile()) {
					try {
						files.add(file.getCanonicalPath());
					}
					catch (IOException e) {
						throw new SearchDomainException("Error: File not found in directory " + dataFolderLocation);
					}
				}
			}
		}
		else {
			throw new SearchDomainException("Error: Directory not found " + dataFolderLocation);
		}

		return files;
	}
	
}
