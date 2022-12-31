package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String fileName = input.nextLine();


		try {


			File file = new File(fileName);
			PrintWriter pWritter = new PrintWriter(file);
			for (int i = 1; i <= 300; i++) {
				if (i % 3 == 0 && i % 5 == 0)
					pWritter.println("FizzBuzz");
				else if (i % 3 == 0)
					pWritter.println("Fizz");
				else if (i % 5 == 0)
					pWritter.println("Buzz");
				else
					pWritter.println(i);

			}
			pWritter.close();
			System.out.println(file + " overwritten successfully.");

		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}







	}

}
