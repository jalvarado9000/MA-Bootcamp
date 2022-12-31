package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class WordSearch {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("What is the fully qualified name of the file that should be searched?\n");
		String userTxt = input.nextLine();//exercise/alices_adventures_in_wonderland.txt
		File fileName = new File(userTxt);



		try(Scanner fileInput = new Scanner(fileName)) {
			boolean isCaseSensitive = false;
			System.out.println("What is the search word you are looking for?");
			String wordSearch = input.nextLine();
			//System.out.println("Should the search be case sensitive? (Y/N)");
			char response = input.nextLine().toLowerCase().charAt(0);
			if(response == 'y')
				isCaseSensitive = true;



			String line = " ";
			int count = 0;


			String bar[];
			while (fileInput.hasNext()) {
				line = fileInput.nextLine();
				count++;
				bar = line.split(" ");

				for (int i = 0; i < bar.length; i++) {
					if (bar[i].equalsIgnoreCase(wordSearch) && isCaseSensitive == false)
						System.out.println(count + ") " + line);
					if(isCaseSensitive && bar[i].contains(wordSearch))
						System.out.println(count + ") " + line);


				}


			}
		}
		catch (FileNotFoundException e) {
			// Could not find the file at the specified path.
			System.out.println("The file was not found: " + fileName.getAbsolutePath());
		}









	}

}
