package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class SearchPage extends TestBase {
	
	@FindBy(xpath = "//a/span[text()='Apple iPhone XR (64GB) - Yellow']/parent::a")
	public WebElement searchForIphone;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void searchAndSelectProduct() {
		searchForIphone.click();
	}
}
