package collections;

import java.util.ArrayList;
import java.util.List;

public class LearnGenerics {

	public static void main(String[] args) {

		// Earlier to Java 1.5
		
		// Create a List
		ArrayList mentors = new ArrayList();

		// Add mentors to the List -- Note the order
		mentors.add("Gopi");
		mentors.add("123");
		mentors.add("Sethu");
		mentors.add("Lokesh");
		mentors.add("Chaitanya");
		
		// Print the last added mentor
		String lastMentor = (String) mentors.get(mentors.size()-1);
		
		// Why Generics cannot be Primitive Data types?
		

	}

}





