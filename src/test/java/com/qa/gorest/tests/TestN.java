package com.qa.gorest.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestN {
	@BeforeMethod
	public void beforeM() {
		System.out.println("beforeM...beforMethod.....1");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
	}
	@BeforeTest
	public void beforT() {
		System.out.println("beforeT.....BeforTest");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
	}
	@Test
	public void t1() {
		System.out.println("TEST....1");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
	}
	@Test
	public void t2() {
		System.out.println("TEST....2");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
	}
	@Test
	public void t3() {
	System.out.println("TEST....3");
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
	}
	@Test
	public void t4() {
		System.out.println("TEST....4");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
}

}
