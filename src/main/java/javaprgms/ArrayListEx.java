package javaprgms;

import java.util.ArrayList;

public class ArrayListEx {

	public static void main(String[] args) {
		ArrayList<Object> al = new ArrayList<Object>(5);
		al.add(0,"Sri");
		al.add(1, 266998);
		al.add(2, 558899);
		System.out.println(al.size());
		System.out.println(al);
	}
}
