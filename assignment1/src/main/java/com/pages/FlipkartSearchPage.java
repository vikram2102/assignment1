package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class FlipkartSearchPage extends TestBase{
	@FindBy(xpath = "//div[text()='Apple iPhone XR (Yellow, 64 GB)']")
	public WebElement searchForIphone;
	
	public FlipkartSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void searchAndSelectProduct() {
		searchForIphone.click();
	}
}
