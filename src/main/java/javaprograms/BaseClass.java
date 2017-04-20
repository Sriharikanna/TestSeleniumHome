package javaprograms;

public class BaseClass {

	// Private variables & Methods

	private int a = 10;
	private int b = 30;

	private void method() {
		int sum = a + b;
	}

	// public variables & methods

	static public int a1 = 10;
	public int b1 = 20;

	public int method1() {
		int sum1 = a1 + b1;
		return sum1;
	}

	// protected variables & methods
	protected int a2 = 100;
	protected int b2 = 20;

	protected int method2() {
		int sum2 = a2 + b2;
		return sum2;
	}
	
	// Final Keyword
	
	final String str = " Hey wait up ";
	
	//static variables
	
	static double pi = 3.14;

}
