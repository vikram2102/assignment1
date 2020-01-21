package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class FlipkartProductDetailPage  extends TestBase {
	@FindBy(xpath="//div[@class='_1vC4OE _3qQ9m1']")
	WebElement price;
	
	public FlipkartProductDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	public int getPrice() {
		return Integer.parseInt(price.getText().replaceAll("[^0-9]", ""));
	}
}
