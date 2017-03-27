
package Attributes;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PriorityAttribute {
	/*
	 * by default test annotations is evaluated by alphabetic order that is
	 * gg/h/z methods.
	 */
	// Priority counts from scale 1-10 *1 is the utmost priority
	// After providing priority scale in Test annotations (This will be evaluated in the order z/h/gg)

	@Test(priority = 2, invocationCount = 3)
	public void h() {
		System.out.println("H @Test");
	}

	@Test(priority = 3)
	public void gg() {
		System.out.println("gg @ Test");
	}

	@Test(priority = 1)
	public void z() {
		System.out.println("Z @ Test");
	}

	@BeforeSuite
	public void b() {
		System.out.println("B @ BSuite");
	}

	@AfterSuite
	public void c() {
		System.out.println("C @AfterSuite");
	}

	@AfterTest
	public void d() {
		System.out.println("D @AfterTest");
	}

	@BeforeTest
	public void e() {
		System.out.println("E @BeforeTest");
	}

	@BeforeClass
	public void f() {
		System.out.println("F @BeforeClass");
	}

	@AfterClass
	public void g() {
		System.out.println("G @AfterClass");
	}

	@BeforeMethod
	public void i() {
		System.out.println("I@ BMethod");
	}

	@BeforeMethod
	public void l() {
		System.out.println("L@ BMethod");
	}

	@AfterMethod
	public void j() {
		System.out.println("J @AFterMethod");
	}

	@BeforeSuite
	public void k() {
		System.out.println("K @ BSuite");
	}
}
