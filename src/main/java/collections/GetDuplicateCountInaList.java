package collections;

import java.util.ArrayList;
import java.util.List;

public class GetDuplicateCountInaList {


	public static void main(String[] args) {
		
		List<String> mentors = new ArrayList<String>();

		// Add mentors to the set -- Note the order
		mentors.add("Gopi");
		mentors.add("Karim");
		mentors.add("Nesa");
		mentors.add("Lokesh");
		mentors.add("Karim");
		mentors.add("Sunil");
		
		String checkDuplicates = "Karim";
		int i=0;
		for (String mentor : mentors) {			
			if(mentor.equals(checkDuplicates)){
				i++;
			}
		}
		System.out.println(i);
		
		
		
		
		
		
		
		
		
		
		
		
		


	}

}
