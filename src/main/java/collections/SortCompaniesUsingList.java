package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortCompaniesUsingList {

	public static void main(String[] args) {
		
		List<String> cmp = new ArrayList<String>();
		
		cmp.add("HCL");
		cmp.add("Hexaware");
		cmp.add("Tcs");
		
		Collections.sort(cmp);
		for (int i = cmp.size()-1; i >= 0; i--) {
			System.out.println(cmp.get(i));
		}
		
	}
}












