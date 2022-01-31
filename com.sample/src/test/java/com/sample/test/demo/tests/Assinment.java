package com.sample.test.demo.tests;

import org.testng.annotations.Test;

import com.objectrepositories.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
//import java.util.logging.FileHandler;


import org.apache.log4j.rewrite.PropertyRewritePolicy;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Assinment extends BaseClass {
	Locators loc = new Locators();

	@AfterMethod
	public void afterMethod() throws Exception {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMMdd_HHmmss");
		String timeStamp = df.format(d);
		File abc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(abc, new File(".\\Screenshots\\test" + timeStamp + ".PNG"));
	}

	@BeforeClass
	public void beforeClass() throws Exception {
		// /com.sample/src/test/resources/config.properties

		FileInputStream fi = new FileInputStream("./src/test/resources/config.properties");
		p.load(fi);
		// System.setProperty("webdriver.chrome.driver",
		// "./src/test/resources/chromedriver/windows/chromedriver.exe");
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(p.getProperty("Pizza_Order_Form_url"));
	}

	// TestCase01
	// Verify error messages
	@Test
	public void testcase_01_verify_error_messeges() throws Exception {
		FileInputStream fi = new FileInputStream("./src/test/resources/config.properties");
		p.load(fi);
		driver.findElement(loc.POF_PlaceOrder_Button).click();
		Thread.sleep(3000);
		String error_message_text = driver.findElement(loc.POF_dialogText).getText();

		if (error_message_text.contains("Missing name")) {
			System.out.println("Dilog box open with error message");
		}

		System.out.println(error_message_text);

	}

//	TestCase02
//	Place the Pizza order using credit card payment
	@Test
	public void testcase_02_place_the_pizza_order_using_credit_card_payment() throws Exception {
		FileInputStream fi = new FileInputStream("./src/test/resources/config.properties");
		p.load(fi);
		driver.navigate().refresh();
		Thread.sleep(3000);
		// public void selectByVisibleText(By locater, String visibleText) {

		WebElement element = driver.findElement(loc.POF_Pizza1_Dropdown);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				String pizza = "Small 6 Slices - no toppings $6.75";
				dropdown.selectByVisibleText(pizza);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

//code for Topping1

		WebElement element_topping1 = driver.findElement(loc.POF_Toppings1_Dropdown);
		if (element_topping1.isDisplayed()) {
			if (element_topping1.isEnabled()) {
				Select dropdown = new Select(element_topping1);
				String topping1 = "Diced Mango";
				dropdown.selectByVisibleText(topping1);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");

		}

		// code for Topping2
		WebElement element_topping2 = driver.findElement(loc.POF_Toppings1_Dropdown);
		if (element_topping2.isDisplayed()) {
			if (element_topping2.isEnabled()) {
				Select dropdown = new Select(element_topping2);
				String topping2 = "Diced Mango";
				dropdown.selectByVisibleText(topping2);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");

		}
		// Quantity
		driver.findElement(loc.POF_Qty_EditBox).clear();
		driver.findElement(loc.POF_Qty_EditBox).sendKeys("1");
		// name,email,mobile

		driver.findElement(loc.POF_Name_EditBox).sendKeys("ss");
		driver.findElement(loc.POF_Email_EditBox).sendKeys("sss@test.com");
		driver.findElement(loc.POF_Phone_EditBox).sendKeys("999-999-9999");

		// card radio

		driver.findElement(loc.POF_CreditCard_Radio).click();
		// place order button
		driver.findElement(loc.POF_PlaceOrder_Button).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//*[@id='dialog']/p")).getText());

	}

//	TestCase3
//	Place the Pizza order using cash on pickup option	

	@Test
	public void testcase_03_place_the_pizza_order_using_cash_on_pickup_option() throws Exception {
		FileInputStream fi = new FileInputStream("./src/test/resources/config.properties");
		p.load(fi);
		driver.navigate().refresh();
		Thread.sleep(3000);

		WebElement element = driver.findElement(loc.POF_Pizza1_Dropdown);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
//				Small 6
//				Slices - no toppings $6.75
				String pizza = "Small 6 Slices - no toppings $6.75";
				dropdown.selectByVisibleText(pizza);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

//code for Topping1

		WebElement element_topping1 = driver.findElement(loc.POF_Toppings1_Dropdown);
		if (element_topping1.isDisplayed()) {
			if (element_topping1.isEnabled()) {
				Select dropdown = new Select(element_topping1);
				String topping1 = "Diced Mango";
				dropdown.selectByVisibleText(topping1);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");

		}

//code for Topping2
		WebElement element_topping2 = driver.findElement(loc.POF_Toppings1_Dropdown);
		if (element_topping2.isDisplayed()) {
			if (element_topping2.isEnabled()) {
				Select dropdown = new Select(element_topping2);
				String topping2 = "Diced Mango";
				dropdown.selectByVisibleText(topping2);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");

		}
// Quantity
		driver.findElement(loc.POF_Qty_EditBox).clear();
		driver.findElement(loc.POF_Qty_EditBox).sendKeys("1");
//name,email,mobile

		driver.findElement(loc.POF_Name_EditBox).sendKeys("ss");
		driver.findElement(loc.POF_Email_EditBox).sendKeys("sss@test.com");
		driver.findElement(loc.POF_Phone_EditBox).sendKeys("999-999-9999");

//card radio

		driver.findElement(loc.POF_CashPayment_Radio).click();
//place order button
		driver.findElement(loc.POF_PlaceOrder_Button).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//*[@id='dialog']/p")).getText());


	}

	@AfterClass
	public void afterClass() throws Exception {
		driver.quit();
		
	}

}
