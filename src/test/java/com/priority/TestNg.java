package com.priority;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg {
	
	@BeforeClass
	private void beforeclass() {

		System.out.println("beforeclass");
	}

	@AfterClass
	private void afterclass() {

		System.out.println("afterclass");
	}

	@BeforeMethod
	private void beforemethod() {

		System.out.println("beforemethod");
	}

	@AfterMethod
	private void aftermethod() {

		System.out.println("aftermethod");

	}
	
	@Test
	private void tc01() {

		System.out.println("tc01");
	}

	@Test
	private void tc02() {
		System.out.println("tc02");
	}
	
}
