package com.priority;

import org.testng.annotations.Test;

public class PriorityTest {
	
	@Test(priority=10)
	private void tc01() {

		System.out.println("tc01");
	}
	
	@Test(priority=-8)
	
	private void tc02() {

		System.out.println("tc02");
	}

	@Test(priority=6)
	private void tco3() {

		System.out.println("tc03");
	}
}
