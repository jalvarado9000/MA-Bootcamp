package com.techelevator;
import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);


		System.out.println("Please enter the length");
		int length = input.nextInt();
		double meters = length * 0.3048;
		double feet = length * 3.2808399;
		System.out.println("Is the measurement in (m)eter, or (f)eet?");
		char measurment = input.next().toLowerCase().charAt(0);

		if(measurment == 'f')
			System.out.println(length + "f is " + (int)meters + "m");
		else if(measurment == 'm')
			System.out.println(length + "m is " + (int)feet + "m");
		else
		{}






	}

}
