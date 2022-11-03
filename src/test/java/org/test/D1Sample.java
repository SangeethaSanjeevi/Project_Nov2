package org.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class D1Sample {
	@BeforeClass
	private void beforeClass() {
		System.out.println("before Class");
	}
	@AfterClass
	private void afterClass() {
		System.out.println("After Class");
	}
	@BeforeMethod
	private void beforeMethod() {
		System.out.println("Before Method");
	}
	@AfterMethod
	private void afterMethod() {
		System.out.println("After method");
	}
	@Test(priority=1)
	private void test3() {
		System.out.println("test case 3");
	}
	@Test(priority=-5)
	private void test1() {
		System.out.println("test case 1");
	}
	@Test(priority=0,enabled=false)
	private void test2() {
		System.out.println("test case 2");

	}
	
}
