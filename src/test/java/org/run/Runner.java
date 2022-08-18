package org.run;

import java.io.IOException;

import org.base.BaseClass;
import org.pojo.Pojo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.ExcelUtils;

public class Runner extends BaseClass {
	
	@BeforeClass
	private void browserLaunch() {

		launchBrowser();
		maxBrowser();
		
	}
	@BeforeClass
	private void setupTestData() throws IOException {
		
		System.out.println("setup test level data");
		
		ExcelUtils.setExcelFileSheet("Status");

	}

	@AfterClass
	private void browserClose() {
		closebrowser();

	}

	@BeforeMethod
	public void startstime() {
		passUrl("https://en-gb.facebook.com/");

	}

	@AfterMethod
	public void endsTime() throws InterruptedException {

		Thread.sleep(3000);

	}
	
	@Test
	
	private void invalidTest() throws IOException {

		Pojo p=new Pojo();
		
		toInput(p.getTxtuser(), excelRead(1, 2));
		toInput(p.getTxtpass(), excelRead(2, 2));
	}
		
		
		
		
		

	}
	

