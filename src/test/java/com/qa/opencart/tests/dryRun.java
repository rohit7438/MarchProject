package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dryRun {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BEFORE SUITE");
	}

	
	@org.testng.annotations.BeforeMethod
	public void BeforeMethod() {
		System.out.println("BEFORE METHOD");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("BEFORE TEST");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("BEFORE CLASS");
	}
	
	
	@Test
	public void myTest() {
		System.out.println("TEST");
	}
	
	
	
	
	
}
