package arrays.learn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDupsFromArray {

	public static void main(String[] args) {

		// Given an array int data[] = {1,2,2,3,4,4,5,5,6,7}
		// Find the non duplicates and print

		int data[] = {1,2,2,3,4,4,5,5,6,7};
		Arrays.sort(data);


		// Option 1
		System.out.print(data[0]);
		for (int i = 1; i < data.length; i++) {
			if(data[i] != data[i-1])
				System.out.print(","+data[i]);
		}


		// Option 2
		Set<Integer> unique = new HashSet<Integer>();
		for (int i = 0; i < data.length; i++)
			unique.add(data[i]);

		System.out.println(unique);


	}

}
