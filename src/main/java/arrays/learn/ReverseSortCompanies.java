package arrays.learn;

import java.util.Arrays;

public class ReverseSortCompanies {

	public static void main(String[] args) {
		
		String[] companies =
			{"HCL", "CTS", "AMAZON"};
		
		Arrays.sort(companies);
		for (int i = companies.length - 1; i >=0 ; i--) {
			System.out.println(companies[i]);
		}
	}
}
