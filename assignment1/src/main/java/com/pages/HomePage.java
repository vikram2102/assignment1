package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBar;
	
	@FindBy(xpath="//input[@type='submit' and @class='nav-input']")
	WebElement searchBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void setSearchBarText(String text) {
		searchBar.sendKeys(text);
	}
	
	public void clickOnSerach() {
		searchBtn.click();
	}
}
