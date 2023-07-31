package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	WebDriver driver;
	Properties prop;
	OptionsManager optionsmanager;

	/**
	 * 
	 * @param prop
	 * @return
	 */
	public WebDriver intiDriver(Properties prop) {
		String browserName = prop.getProperty("browser");
		optionsmanager = new OptionsManager(prop);
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver(optionsmanager.getChromeOptions());
			break;
		case "firefox":
			driver = new FirefoxDriver(optionsmanager.getFirefoxOptions());
			break;

		case "edge":
			driver = new EdgeDriver(optionsmanager.getEdgeOptions());
			break;

		default:
			System.out.println("Pass valid browser");
			break;
		}

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	/**
	 * 
	 * @return
	 */
	public Properties initProperties() {
		 prop = new Properties();
		FileInputStream ip = null;

		String envName = System.getProperty("env");
		try {
		if (envName == null) {
			ip = new FileInputStream("./src/testResources/config/QA.config.properties");
		}

		else {
			switch ((envName).toLowerCase().trim()) {

			case "qa":
				ip = new FileInputStream("./src/testResources/config/QA.config.properties");
				System.out.println("Running on QA");
				break;

			case "uat":
				ip = new FileInputStream("./src/testResources/config/UAT.config.properties");
				System.out.println("Running on UAT");
				break;

			case "dev":
				ip = new FileInputStream("./src/testResources/config/DEV.config.properties");
				System.out.println("Running on DEV");
				break;

			default:
				System.out.println("Not a coreect environment");
				break;
			}
		}
		}
		
		
		catch (Exception e) {
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
		return prop;
	}
	
	
	
	

	
	
}
