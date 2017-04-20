package javaprograms;

import org.junit.Test;

public class SubOfSub {
@Test
	public void subclass()
	{
		BaseClass obj = new BaseClass();
		System.out.println("before changing static variable :"+obj.a1);
		obj.a1=50;
		System.out.println("After changing the static variable :"+obj.a1);
		
	}
}
