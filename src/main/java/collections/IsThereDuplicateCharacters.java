package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class IsThereDuplicateCharacters {

	public static void main(String[] args) {
		
		// Lets write Psuedocode first
		// Goal ?? If there is repeating character -- then print false ; else true
		
		// 1, Convert the string to the character array(toCharArray())
		// 2, Loop through each character (use foreach)
		// 3, If the character is in map key then print duplicate and break (containsKey(""))
		// 4, If not add to the map (put(k,v))
		
		String companyName = "Paypal India";
			
		// convert to character array
		char[] allChars= companyName.toCharArray();
		
		// create a map to store the character and its
		// associated occurrence (Integer)
		Map<Character, Integer> map = new HashMap<>();
		
		// Take one character at a time
		for (char c : allChars) {
			
			// If the character exists in the map
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1); // get the key' value and increment 1 to it
			}else{
				map.put(c, 1); // add to the map for the first time occurence
			}
		}
		
		System.out.println(map);
	}

	
	
	
	
	
	
	
}
