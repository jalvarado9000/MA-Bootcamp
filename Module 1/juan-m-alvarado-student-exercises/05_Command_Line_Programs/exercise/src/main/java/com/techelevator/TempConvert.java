package com.techelevator;
import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {





		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the temperature ");
		int tempNumber = input.nextInt();
		double temperatureCelcius = (tempNumber - 32) / 1.8;
		double temperatureFarenheit = tempNumber * 1.8 + 32;

		System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit?");
		char tempSymbol = input.next().toLowerCase().charAt(0);
		if( tempSymbol == 'c')
			System.out.println(tempNumber + "C is " + (int)temperatureCelcius + "F");
		else if(tempSymbol == 'f')
			System.out.println(tempNumber + "F is " + (int)temperatureCelcius + "C");





	}

}
