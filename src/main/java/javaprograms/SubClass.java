package javaprograms;

import org.junit.Test;

public class SubClass extends BaseClass {

	@Test
	public void manipulation() {
		/*
		 * method(); // This can't be done since the access modifier for the
		 * method we are calling is private
		 */
		// a=50; This private variable can't be accessed since it is specific to
		// that class
		// Accessing Public methods and variables
		System.out.println("Printing public method from base class");
		System.out.println("Printing the \"method1\" from base class: " + "\'" + method1() + "\'");
		System.out.println("Calling changeVaraibales method");
		changeVariables();
		System.out.println("Print \"a1\" value after changing: " + "\"" + a1 + "\"");
		System.out.println("Printing public method from base class");
		System.out.println("Printing the \"method1\" from base class: " + "\'" + method1() + "\'");
		System.out.println("Printing the sysout stmt from the manipulation class");
		// Accessing protected methods and variables
		System.out.println("Printing the Protected method from base class: " + method2());
		a2 = a2 + 200;
		b2 = b2;
		System.out.println("Printing protected method after changing variables: " + method2());
		System.out.println("printing string from base class :" + str);
		/* str = "Hello"; */ /*
								 * This can't be done since the final keyword
								 * don't let the developer to change the value
								 * of the string// But its allowed to use it or
								 * print it
								 */
		System.out.println("Triming the white spaces :" + str.trim());
		System.out.println("Printing static variable :" + pi);
		pi = 4.5;
		System.out.println("After changing the value of pi :" + pi);
		changeVariables();
	}

	public void changeVariables() {
		a1 = 25;
		b1 = 50;
		System.out.println("Printing the \"method1\" from base class after changing the variables in Subclass: " + "\'"
				+ method1() + "\'");
		System.out.println("Printing pi: " + pi);
	}

}

/*
 * What is the learnings here??
 * 
 * If you inherit the properties of base class, you have access to all the type
 * of variables except private variables/methods.
 */
