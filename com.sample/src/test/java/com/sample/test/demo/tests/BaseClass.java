package com.sample.test.demo.tests;

import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	public static RemoteWebDriver driver;
	public static Properties p = new Properties();
	
	
	public static String projectDir; 
	public static String screenshotPath;
	public static String className; 
	public static String methodName;
}
