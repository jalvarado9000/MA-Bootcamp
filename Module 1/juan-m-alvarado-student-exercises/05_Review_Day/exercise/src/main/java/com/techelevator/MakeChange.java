package com.techelevator;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean flag = false;
		do {
			System.out.println("Please enter the amount of the bill:");
			double billAmount = input.nextDouble();
			System.out.println("Please enter the amount tendered:");
			double tenderAmount = input.nextDouble();
			double changeRequired = tenderAmount - billAmount;

			DecimalFormat f = new DecimalFormat("##.00");

			if (billAmount > tenderAmount) {
				System.out.println("Insufficient Amount please add $" + f.format(Math.abs(changeRequired))  + " to complete the payment");
				System.out.println("Please try again");
				flag = true;
			}
			else
				System.out.println("The change required is " + f.format(changeRequired));

		}while(flag);






	}

}
