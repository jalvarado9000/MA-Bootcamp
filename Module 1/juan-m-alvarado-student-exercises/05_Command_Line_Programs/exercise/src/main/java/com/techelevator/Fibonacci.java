package com.techelevator;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a Integer");
		int number = input.nextInt();

		int sequenceNumber = 0;
		int sequenceSetter = 1;

		for(int sumOfNumbers = 0; sumOfNumbers < number; sumOfNumbers++){

			if(sequenceNumber > number || sequenceNumber == number)
				break;
			System.out.println(sequenceNumber + " ");
			int temporaryNumber = sequenceSetter + sequenceNumber;
			sequenceNumber = sequenceSetter;
			sequenceSetter = temporaryNumber;


		}






	}

}
