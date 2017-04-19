package collections;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GetCountOfEachCharacter {

	public static void main(String[] args) {

		// Lets write Psuedocode first
		// Goal ?? Count of every character in a String
		/*
		String date = "Amazon India Development Center";
		char[] allChars= date.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

		for (char c : allChars) {

			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);

			}else{
				map.put(c, 1);
			}
		}


		System.out.println(map);

		 */

		// Class room Session.. [Psuedo Code] 
		// In a given String, find the most number of repeating character
		String company = "Amazon India Development Center";

		char[] allCharacters= company.toCharArray();
		Map<Character, Integer> compMap = new LinkedHashMap<Character, Integer>();

		for (char c : allCharacters) {
			if(compMap.containsKey(c)){
				compMap.put(c, compMap.get(c)+1);			
			}else{
				compMap.put(c, 1);
			}
		}

		System.out.println(compMap);

		int maxCount = 0;
		char maxChar = 0;
		// Get the value of each key and see if it bigger than other
		for (Entry<Character, Integer> charKey : compMap.entrySet()) {

			System.out.println("The key is: "+charKey.getKey()+""
					+ " and value is: "+charKey.getValue()); 	
			
			if(charKey.getValue() >= maxCount){
				maxCount = charKey.getValue();
				maxChar = charKey.getKey();
			}
			
		}
		
		System.out.println(maxChar+" --> "+maxCount);

	}

}



