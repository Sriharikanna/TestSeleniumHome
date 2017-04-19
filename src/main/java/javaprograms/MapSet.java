package javaprograms;

import java.util.HashMap;
import java.util.Map;

public class MapSet {

	public static void main(String[] args) {
		String text = "Hello All Welcome to India";
		String textTofind = text.toUpperCase();
		System.out.println(textTofind);
		char arrayText[] = textTofind.toCharArray();
		int j = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < arrayText.length; i++) {
			char letterToFind = arrayText[i];
			if (!map.containsKey(letterToFind)) {
				map.put(letterToFind, 1);
			} else {
				map.put(letterToFind, map.put(letterToFind, 1) + 1);
			}
		}
		System.out.println("Printing Map"+map.entrySet());
	}
}
