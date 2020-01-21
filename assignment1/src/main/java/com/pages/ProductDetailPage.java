package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class ProductDetailPage extends TestBase {
	@FindBy(id="priceblock_ourprice")
	WebElement price;
	
	public ProductDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	public int getPrice() {
		return Integer.parseInt(price.getText().replaceAll("[^0-9]", ""));
	}
}
