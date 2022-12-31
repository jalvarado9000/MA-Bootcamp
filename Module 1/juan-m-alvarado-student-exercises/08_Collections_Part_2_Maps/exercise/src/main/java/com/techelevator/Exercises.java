package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		Map<String,String> animalGroup = new HashMap<String,String>();
		String group = "";

		if(animalName == null)
			return "unknown";

			switch(animalName.toLowerCase()){
				case "rhino" : group = "Crash";
					break;
				case "deer" : group = "Crash";
					break;
				case "giraffe" : group = "Tower";
					break;
				case "elephant" : group = "Herd";
					break;
				case "lion" : group = "Pride";
					break;
				case "crow" : group = "Murder";
					break;
				case "pidgeon" : group = "Kit";
					break;
				case "flamingo" : group = "Pat";
				case "dog" : group = "Pack";
					break;
				case "crocodile" : group = "Float";
					break;
				default : group = "unknown";
					break;
			}
			animalGroup.put(animalName,group);
		return animalGroup.get(animalName);
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {

		Map<String,Double> discountCodes = new HashMap<String,Double>();
		double discount = 0.00;

		if(itemNumber == null)
			return discount;

		switch(itemNumber.toUpperCase()){
			case "KITCHEN4001" : discount = 0.20;
				break;
			case "GARAGE1070" : discount = 0.15;
				break;
			case "LIVINGROOM" : discount = 0.10;
				break;
			case "KITCHEN6073" : discount = 0.40;
				break;
			case "BEDROOM3434" : discount = 0.60;
				break;
			case "BATH0073" : discount = 0.15;
				break;
			default : discount = 0.0;
				break;
		}
		discountCodes.put(itemNumber,discount);

		return discountCodes.get(itemNumber);


	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		Map<String,Integer> monetaryAmount = new HashMap<String,Integer>();
		int size = peterPaul.size();
		boolean isPeterBigger = peterPaul.get("Peter") >= 0;
		boolean isLess = peterPaul.get("Paul") < 1000;


		if(isPeterBigger && isLess) {
			int peterHalf = (int) (peterPaul.get("Peter") / 2);
			int paulsMoney = peterPaul.get("Paul") +peterHalf;

			if(peterPaul.get("Peter") % 5 == 0 && peterPaul.get("Peter") % 2 == 1)
				peterHalf+=1;

			peterPaul.put("Peter", peterHalf);
			peterPaul.put("Paul",paulsMoney);
		}

		return peterPaul;

	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {

		boolean has50 = peterPaul.get("Peter") >= 5000;
		boolean has100 = peterPaul.get("Paul") >= 10000;
		double contribution = 0.25;
		int remainigPeter = peterPaul.get("Peter") - (int)(peterPaul.get("Peter") * contribution);
		int remainingPaul = (int) (peterPaul.get("Paul") -(peterPaul.get("Paul") * contribution));
		int partnership = (int)(peterPaul.get("Peter") * contribution + (int)(peterPaul.get("Paul") * contribution)) ;

		if(has50 && has100){
			peterPaul.put("Peter",remainigPeter);
			peterPaul.put("Paul",remainingPaul);
			peterPaul.put("PeterPaulPartnership", partnership);
	}
		return peterPaul;

	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		int size = words.length;
		Map<String,String> differentLetters = new HashMap<String,String>();

		for (int i = 0; i < size; i++) {
			String firstLetter = String.valueOf(words[i].charAt(0));
			String lastLetter = String.valueOf(words[i].charAt(words[i].length()-1));
			differentLetters.put(firstLetter,lastLetter);
		}

		return differentLetters;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		int size = words.length;
		String[] compare = new String[size];
		int counter = 0;
		Map<String,Integer> charCounter = new HashMap<String,Integer>();

		for (int i = 0; i < size; i++)
			compare[i] = words[i];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(words[i] == compare[j])
					counter++;
			}
			charCounter.put(words[i], counter);
			counter = 0;

		}


		return charCounter;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {

		int size = ints.length;
		int[] compare = new int [size];
		int counter = 0;
		Map<Integer,Integer> intCounter = new HashMap<Integer,Integer>();

		for (int i = 0; i < size; i++)
			compare[i] = ints[i];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(ints[i] == compare[j])
					counter++;
			}
			intCounter.put(ints[i], counter);
			counter = 0;

		}

		return intCounter;
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		int size = words.length;
		String[] compare = new String[size];
		int counter = 0;
		Map<String,Boolean> charCounter = new HashMap<String,Boolean>();

		for (int i = 0; i < size; i++)
			compare[i] = words[i];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(words[i] == compare[j])
					counter++;

			}
			if(counter > 1 )
			charCounter.put(words[i], true);
			else
				charCounter.put(words[i], false);

			counter = 0;

		}
		return charCounter;
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {


		Map<String, Integer> allWarehouse = new HashMap<String,Integer>(mainWarehouse);

		for(String warehouse : mainWarehouse.keySet()){
			if(remoteWarehouse.containsKey(warehouse))
				allWarehouse.put(warehouse,(mainWarehouse.get(warehouse) + remoteWarehouse.get(warehouse)));
			else
				allWarehouse.put(warehouse, mainWarehouse.get(warehouse));
		}

		for(String warehouse : remoteWarehouse.keySet()){
			if((allWarehouse.containsKey(warehouse)))
				continue;
			else
				allWarehouse.put(warehouse, remoteWarehouse.get(warehouse));


		}

		return allWarehouse;





	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {

		Map<String, Integer> last2 = new HashMap<String,Integer>();

		int size = words.length;


		for (int i = 0; i < size; i++) {
			int size2 = words[i].length();
			int counter = -1;
			for (int j = 0; j < size2; j++) {
				int u = j+2;
				if(u > size2)
					break;

				String repeatedWord = words[i].substring(j,u);
				if(words[i].substring(size2 - 2, size2).equals(repeatedWord) ) {
					counter++;
					last2.put(words[i],counter);

				}



			}



		}






		return last2;
	}

}
