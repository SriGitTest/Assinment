package com.objectrepositories;

import org.openqa.selenium.By;

public class Locators {
	//POF= Pizza Order Form
	public final By POF_Pizza1_Dropdown = By.id("pizza1Pizza");
	public final By POF_Toppings1_Dropdown = By.xpath("//div[@id='pizza1']//select[@class='toppings1']");
	public final By POF_Toppings2_Dropdown = By.xpath("//div[@id='pizza1']//select[@class='toppings2']");
	public final By POF_Qty_EditBox = By.id("pizza1Qty");
	public final By POF_Cost_EditBox = By.id("pizza1Cost");
	public final By POF_CreditCard_Radio = By.id("ccpayment");
	//cashpayment
	public final By POF_CashPayment_Radio = By.id("cashpayment");

	public final By POF_Email_EditBox = By.id("email");
	public final By POF_Name_EditBox = By.id("name");
	public final By POF_Phone_EditBox = By.id("phone");
	public final By POF_PlaceOrder_Button = By.id("placeOrder");
	public final By POF_Reset_Button = By.id("reset");
	public final By POF_dialog = By.id("dialog");
	public final By POF_dialogText = By.xpath("//div[@id='dialog']/p");
	
	
}
