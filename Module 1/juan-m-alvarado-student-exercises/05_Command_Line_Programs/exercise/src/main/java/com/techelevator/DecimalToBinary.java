package com.techelevator;
import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("enter a decimal number to be converted to binary");
		int decimal = input.nextInt();

		int[] binaryNumbers = new int[30];
		int size = 0;
		for(; decimal > 0;size++){
			binaryNumbers[size] = decimal%2;
			decimal = decimal/2;
		}

		for(int i = size - 1; i >= 0; i--)
			System.out.print(binaryNumbers[i]);






	}

}
